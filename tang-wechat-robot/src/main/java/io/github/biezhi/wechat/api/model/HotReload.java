package io.github.biezhi.wechat.api.model;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.client.BotClient;
import lombok.Data;
import okhttp3.Cookie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自动登录字段
 *
 * @author biezhi
 * @date 2018/1/21
 */
@Data
public class HotReload {

	private LoginSession session;
	private Map<String, List<Cookie>> cookieStore;

	public static HotReload build(LoginSession session, BotClient bot) {
		HotReload hotReload = new HotReload();
		hotReload.setSession(session);
		hotReload.setCookieStore(bot.cookieStore());
		return hotReload;
	}

	/**
	 * 重新登录
	 */
	public static void reLogin(WeChatBot bot, HotReload  hot) {
		bot.getBotClient().recoverCookie(hot.cookieStore);
		bot.setSession(hot.session);
	}
	
	public static void clearLogin(WeChatBot bot) {
		bot.getBotClient().recoverCookie(new HashMap<String, List<Cookie>>());
	}
}
