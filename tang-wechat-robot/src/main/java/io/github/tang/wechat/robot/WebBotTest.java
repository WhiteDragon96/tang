package io.github.tang.wechat.robot;

import com.alibaba.fastjson.JSON;
import io.github.tang.wechat.api.WeChatApiImpl;
import io.github.tang.wechat.api.annotation.Bind;
import io.github.tang.wechat.api.constant.Config;
import io.github.tang.wechat.api.enums.AccountType;
import io.github.tang.wechat.api.enums.MsgType;
import io.github.tang.wechat.api.model.Account;
import io.github.tang.wechat.api.model.WeChatMessage;
import io.github.tang.wechat.api.request.StringRequest;
import io.github.tang.wechat.api.response.ApiResponse;
import io.github.tang.wechat.pool.MyThreadPool;
import io.github.tang.wechat.res.TianRes;
import io.github.tang.wechat.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 我的小机器人
 *
 * @date 2018/1/19
 */
@Slf4j
@Component
public class WebBotTest extends WeChatBot {

    @Autowired
    private WeChatApiImpl weChatApi;

    public WebBotTest() {
    }

    public WebBotTest(Config config) {
        super(config);
    }


    @Override
    public void saveAllAccount(List<Account> contactList) {
        log.info(JSON.toJSONString(contactList));
    }

    /**
     * 绑定群聊信息
     *
     * @param message
     */
    @Bind(msgType = MsgType.ALL, accountType = AccountType.TYPE_GROUP)
    public void groupMessage(WeChatMessage message) {
        log.info("接收到群 [{}] 的消息: {}", message.getName(), message.getText());
        // this.api().sendText(message.getFromUserName(), "自动回复: " + message.getText());
        String text = message.getText();
        String url = "https://api.tianapi.com/robot/index?key=bbb921cfb051d7f2ceb5e25b88b783ce&question=" + text;

//		String tixing = HttpRequest.get(url).header("Host", "api.tianapi.com").timeout(30000).execute().body();



		/*TianRes tianRes = JSON.parseObject(tixing, TianRes.class);
		List<TianRes.News> newsList = tianRes.getNewsList();
		String reply = newsList.get(0).getReply();
		System.out.println(reply);*/


        System.out.println(String.format("接收到群 [%s] 的消息: %s", message.getName(), message.getText()));
    }

    /**
     * 绑定私聊消息
     *
     * @param message
     */
    @Bind(msgType = {MsgType.TEXT, MsgType.VIDEO, MsgType.IMAGE,
            MsgType.EMOTICONS}, accountType = AccountType.TYPE_FRIEND)
    public void friendMessage(WeChatMessage message) throws InterruptedException {
        if (StringUtils.isNotEmpty(message.getName())) {
            switch (message.getMsgType()) {
                case TEXT:
                    System.out.println(String.format("接收到好友 [%s] 的消息: %s", message.getName(), message.getText()));

                    String url = "https://api.tianapi.com/robot/index?key=bbb921cfb051d7f2ceb5e25b88b783ce&question=" + message.getText();
                    ApiResponse send = this.client().send(new StringRequest(url));
                    String tixing = send.getRawBody();
                    TianRes tianRes = JSON.parseObject(tixing, TianRes.class);
                    List<TianRes.News> newsList = tianRes.getNewsList();
                    String reply = newsList.get(0).getReply();
                    MyThreadPool.executor.execute(() -> {
                        if (reply != null) {
                            try {
                                Thread.sleep(2000);
//                                this.api().sendText(message.getFromUserName(), reply);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    break;
                case IMAGE:
                    System.out.println(String.format("接收到好友 [%s] 的消息: {%s}", message.getName(), message.getImagePath()));
            }
        }
    }




    /**
     * 好友验证消息
     *
     * @param message
     */
    @Bind(msgType = MsgType.ADD_FRIEND)
    public void addFriend(WeChatMessage message) {
        log.info("收到好友验证消息: {}", message.getText());

//		webRobotService.saveMsg(message);
//		WebRobot robot = webRobotService.getByUserNameFromCache(this.config().weixinId());
//		if (robot.getAutoAddFirend() == BooleanEnum.True.getValue()) {
        this.api().verify(message.getRaw().getRecommend());
//		}
    }

    public static void main(String[] args) {
        WebBotTest bot = new WebBotTest(Config.me().autoLogin(true).showTerminal(false).weixinId("login_config_1"));
        WeChatApiImpl weChatApi = new  WeChatApiImpl(bot);
        bot.start(weChatApi);

        bot.keepRun();
    }

    @PostConstruct
    public void startBot(){
        WebBotTest bot = new WebBotTest(Config.me().autoLogin(true).showTerminal(false).weixinId("login_config_1"));
        weChatApi.setBot(bot);
        weChatApi.setClient(bot.getBotClient());
        bot.start(weChatApi);
        List<Account> groupList = weChatApi.getGroupList();
        bot.keepRun();
    }

}
