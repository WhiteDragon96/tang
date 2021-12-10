package io.github.biezhi.wechat.api.enums;

/**
 * 消息类型
 * <p>
 * ALL: 所有消息
 * TEXT: 普通文本消息, type=1
 * IMAGE: 图片消息，type=3
 * VOICE: 音频消息, type=34
 * ADD_FRIEND: 添加好友请求, type=37
 * VIDEO: 视频消息, type=43, 62
 * PERSON_CARD: 个人名片, type=42
 * EMOTICONS: 动画表情, type=47
 * REVOKE_MSG: 撤回消息, type=10002
 * SYSTEM: 系统消息, type=10000
 * SHARE: 分享, type=49。AppMsgType=33 微信小程序 | AppMsgType=5 链接
 * CONTACT_INIT: 联系人初始化, type=51
 * UNKNOWN: 未知类型
 *
 * @author biezhi
 * @date 2018/1/19
 */
public enum MsgType {

    ALL, TEXT, IMAGE, EMOTICONS, VOICE, VIDEO, PERSON_CARD,
    SYSTEM, ADD_FRIEND, REVOKE_MSG, SHARE, CONTACT_INIT, UNKNOWN

}

/**
 * {
"MsgId": "2321518457872379661",
"FromUserName": "@7662383c937ff9aec3ac7470e85c5382272cbaf1d44c32e9d092c18a20a22bb7",
"ToUserName": "@2d778eb93d5516adb50be827fdf3d0319296c2d0bdaa721f4cae35bc8588f9bf",
"MsgType": 49,
"Content": "&lt;msg&gt;&lt;appmsg appid=\"\" sdkver=\"0\"&gt;&lt;title&gt;约返:0.99 优惠卷:5 付费价33.00&lt;/title&gt;&lt;des&gt;唯资眉笔水眉笔雾眉液体眉笔防水防汗不脱色自然持久不晕染一字眉&lt;/des&gt;&lt;action&gt;view&lt;/action&gt;&lt;type&gt;5&lt;/type&gt;&lt;showtype&gt;0&lt;/showtype&gt;&lt;mediatagname&gt;&lt;/mediatagname&gt;&lt;messageaction&gt;&lt;/messageaction&gt;&lt;content&gt;&lt;/content&gt;&lt;url&gt;http://t.cn/RrBhwLB&lt;/url&gt;&lt;lowurl&gt;&lt;/lowurl&gt;&lt;dataurl&gt;&lt;/dataurl&gt;&lt;lowdataurl&gt;&lt;/lowdataurl&gt;&lt;appattach&gt;&lt;totallen&gt;0&lt;/totallen&gt;&lt;attachid&gt;&lt;/attachid&gt;&lt;emoticonmd5&gt;&lt;/emoticonmd5&gt;&lt;fileext&gt;&lt;/fileext&gt;&lt;cdnthumburl&gt;304f020100044830460201000204f6b1611002032f4f560204b27ac2dc02045b38d5b80421777869645f74367762776e30393475626d32313133315f313533303435313338330204010400030201000400&lt;/cdnthumburl&gt;&lt;cdnthumbmd5&gt;&lt;/cdnthumbmd5&gt;&lt;cdnthumblength&gt;278462&lt;/cdnthumblength&gt;&lt;cdnthumbwidth&gt;800&lt;/cdnthumbwidth&gt;&lt;cdnthumbheight&gt;800&lt;/cdnthumbheight&gt;&lt;cdnthumbaeskey&gt;4a1d522fac524893a3d68637a09e512f&lt;/cdnthumbaeskey&gt;&lt;aeskey&gt;4a1d522fac524893a3d68637a09e512f&lt;/aeskey&gt;&lt;encryver&gt;0&lt;/encryver&gt;&lt;/appattach&gt;&lt;extinfo&gt;&lt;/extinfo&gt;&lt;sourceusername&gt;&lt;/sourceusername&gt;&lt;sourcedisplayname&gt;&lt;/sourcedisplayname&gt;&lt;commenturl&gt;&lt;/commenturl&gt;&lt;thumburl&gt;https://img.alicdn.com/bao/uploaded/i4/425781057/TB1AMYNjaAoBKNjSZSyXXaHAVXa_!!0-item_pic.jpg&lt;/thumburl&gt;&lt;/appmsg&gt;&lt;fromusername&gt;&lt;/fromusername&gt;&lt;scene&gt;0&lt;/scene&gt;&lt;appinfo&gt;&lt;version&gt;1&lt;/version&gt;&lt;appname&gt;&lt;/appname&gt;&lt;/appinfo&gt;&lt;commenturl&gt;&lt;/commenturl&gt;&lt;/msg&gt;",
"Status": 3,
"ImgStatus": 2,
"CreateTime": 1530451384,
"VoiceLength": 0,
"PlayLength": 0,
"FileName": "约返:0.99 优惠卷:5 付费价33.00",
"FileSize": "0",
"MediaId": "",
"Url": "http://t.cn/RrBhwLB",
"AppMsgType": 5,
"StatusNotifyCode": 0,
"StatusNotifyUserName": "",
"RecommendInfo": {
"UserName": "",
"NickName": "",
"QQNum": 0,
"Province": "",
"City": "",
"Content": "",
"Signature": "",
"Alias": "",
"Scene": 0,
"VerifyFlag": 0,
"AttrStatus": 0,
"Sex": 0,
"Ticket": "",
"OpCode": 0
}
 */
