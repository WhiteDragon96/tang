package io.github.tang.wechat.api;

import com.alibaba.fastjson.JSON;
import io.github.tang.wechat.robot.WeChatBot;
import io.github.tang.wechat.api.model.SyncCheckRet;
import io.github.tang.wechat.api.response.WebSyncResponse;
import io.github.tang.wechat.utils.DateUtils;
import io.github.tang.wechat.api.enums.RetCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 轮训监听消息
 *
 * @author tangcs
 * @date 2018/1/21
 */
@Slf4j
public class ChatLoop implements Runnable {

    private WeChatBot bot;
    private WeChatApi api;
    private int retryCount = 0;

    ChatLoop(WeChatBot bot) {
        this.bot = bot;
        this.api = bot.api();
    }

    @Override
    public void run() {
        while (bot.isRunning()) {
        	WebSyncResponse webSyncResponse = null;
            try {
                SyncCheckRet syncCheckRet = api.syncCheck();
                if (syncCheckRet.getRetCode() == RetCode.UNKNOWN) {
                    log.info("未知状态");
                    continue;
                } else if (syncCheckRet.getRetCode() == RetCode.MOBILE_LOGIN_OUT) {
                    log.info("你在手机上登出了微信，再见");
                    api.logout();
                    break;
                } else if (syncCheckRet.getRetCode() == RetCode.LOGIN_OTHERWISE) {
                    log.info("你在其他地方登录了 WEB 版微信，再见");
                    api.logout();
                    break;
                } else if (syncCheckRet.getRetCode() == RetCode.NORMAL) {
                    // 更新最后一次正常检查时间
                    bot.updateLastCheck();
                    webSyncResponse = api.webSync();
                    if(!webSyncResponse.success()) {
                    	api.relogin();
                    	break ;
                    }
                    if(webSyncResponse.getAddMessageList()!=null && webSyncResponse.getAddMessageList().size()>0 && //
                    		webSyncResponse.getAddMessageList().get(0).getRecommend().getAttrStatus()>0) {
                    	System.out.println("Loop Error:" + JSON.toJSONString(webSyncResponse));
                    }
                    switch (syncCheckRet.getSelector()) {
                        case 2:
                            if (null == webSyncResponse) {
                                break;
                            }
                            bot.addMessages(api.handleMsg(webSyncResponse.getAddMessageList()));
                            // 可能有新加入的人
                            if(webSyncResponse.getModContactCount() >0 ) {
                            	api.addAccount(webSyncResponse.getModContactList());
                            }
                            if(webSyncResponse.getModChatRoomMemberCount()>0) {
                            	api.addGroupAccount(webSyncResponse.getModChatRoomMemberList());
                            }
                            break;
                        case 6:
                            log.info("收到疑似红包消息");
                            break;
                        default:
                            break;
                    }
                }
                if (System.currentTimeMillis() - bot.getLastCheckTs() <= 100) {// 30
                    DateUtils.sleep(System.currentTimeMillis() - bot.getLastCheckTs());
                }
            } catch (Exception e) {
                log.warn(e.getMessage());
                retryCount += 1;
                if (bot.getReceiveRetryCount() < retryCount) {
                    bot.setRunning(false);
                } else {
                    DateUtils.sleep(1000);
                }
            }
        }
    }
}
