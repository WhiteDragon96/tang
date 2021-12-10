package io.github.biezhi.wechat;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.AccountType;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.Account;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.res.TianRes;
import io.github.biezhi.wechat.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的小机器人
 *
 * @date 2018/1/19
 */
@Slf4j
public class WebBotTest extends WeChatBot {


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

		String tixing = HttpRequest.get(url).header("Host", "api.tianapi.com").timeout(30000).execute().body();



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
	@Bind(msgType = { MsgType.TEXT, MsgType.VIDEO, MsgType.IMAGE,
			MsgType.EMOTICONS }, accountType = AccountType.TYPE_FRIEND)
	public void friendMessage(WeChatMessage message) throws InterruptedException {
		if (StringUtils.isNotEmpty(message.getName())) {
			switch (message.getMsgType()) {
			case TEXT:
				System.out.println(String.format("接收到好友 [%s] 的消息: %s", message.getName(), message.getText()));
				Map<String,Object> paramMap = new HashMap<>();
//				paramMap.put("query",message.getText());
				String s = JSON.toJSONString(paramMap);
				int length = s.getBytes(StandardCharsets.UTF_8).length;
				/*String body = HttpRequest.post("https://openai.weixin.qq.com/btsapi/v2/bot/query/debug")
						.header(Header.CONTENT_TYPE, "application/json")
						.header(Header.COOKIE, "tvfe_boss_uuid=e1db87e6c4334603; RK=xGB8qO3aSt; ptcz=5e965149b73ec681392e1bcee55129e82905ede1e550e3aae7c0c4e506393946; iip=0; pac_uid=0_f8f489bb85ff6; fqm_pvqid=d8004f5a-7d4d-4a3b-8fb7-af1a468104ec; pgv_pvid=4190260617; sd_userid=38631638336571565; sd_cookie_crttime=1638336571565; pgv_info=ssid=s5324682130; uin=o0805609108; skey=@JaIGqWsG7; wxuin=38862033475890; wxuin.sig=KA5wjze4H8HEtA8eXVUghg6IAYQ; ts_uid=7612656224; ptui_loginuin=1011862667@qq.com; oin:sess=eyJzaWQiOiJtU0NpS0RoMkhJOVdrNVUiLCJyaWQiOjIxODc5MSwib3BlbmlkIjoibzlVLTg1aXI3YTlEMm9oWjZsMW02a0NmbWpiSSIsInNpZ25ldGltZSI6MTYzOTA0MTQ4NjQ3MSwiX2V4cGlyZSI6MTYzOTEyNzg4NjQ3MiwiX21heEFnZSI6ODY0MDAwMDB9; oin:sess.sig=isp3byI4fg3_H4qqeEbxYbl5TdA; ts_refer=www.baidu.com/link; ts_last=openai.weixin.qq.com/@doingddd9f/platform/robotAccount/noMatch; mm_lang=zh_CN")
						.header("wxbot_bid", "c97af57556fd8fb6fcd568163329382b")
						.header(Header.CONTENT_LENGTH, String.valueOf(length))
						.header(Header.CONNECTION, "keep-alive")
						.header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.93 Safari/537.36")
						.header(Header.HOST, "openai.weixin.qq.com")
						.body(s)//表单内容
						.timeout(20000).execute().body();
				System.out.println(body);
				Map parse = (Map) JSON.parse(body);
				Map data = (Map) JSON.parse(String.valueOf(parse.get("data")));*/
				String url = "https://api.tianapi.com/robot/index?key=bbb921cfb051d7f2ceb5e25b88b783ce&question=" +message.getText();
				String tixing = HttpUtil.get(url);
				TianRes tianRes = JSON.parseObject(tixing, TianRes.class);
				List<TianRes.News> newsList = tianRes.getNewsList();
				String reply = newsList.get(0).getReply();

				if (reply != null) {
					Thread.sleep(2000);
					this.api().sendText(message.getFromUserName(), reply);
				}
				break;
				case IMAGE:
					System.out.println(String.format("接收到好友 [%s] 的消息: {%s}", message.getName(), message.getImagePath()));
			}

			// if (message.getImagePath() != null && message.getImagePath().length() > 0) {
			// this.api().sendImg(message.getFromUserName(),
			// "/Users/hp/Documents/workspace/MySvn/myprojects/robot/weixinrobot/wechat-api/assets/qrcode.png");
			// } else {
			// this.api().sendText(message.getFromUserName(), "自动回复: " + message.getText());
			// this.api().modifyUserName(message.getFromUserName(), "txefstXX");
			// }
			// this.api().sendFile("战斗型美少女",
			// "/Users/biezhi/Desktop/Hot_Spots_blade2.0.4_alpha1.html");
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
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// new
		// MyBot(Config.me().autoLogin(true).showTerminal(false).weixinId("weixin2")).start();
		// }
		// }).start();
		WebBotTest bot = new WebBotTest(Config.me().autoLogin(true).showTerminal(false).weixinId("login_config_1"));
		bot.start();
		bot.keepRun();
	}

}
