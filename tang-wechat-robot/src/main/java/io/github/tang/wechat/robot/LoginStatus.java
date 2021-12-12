package io.github.tang.wechat.robot;

public class LoginStatus {
	private int status;// 0未成功登录 1登录成功 2已经退出
	private int qrVersion = 0;//
	private String message;// 提示信息

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getQrVersion() {
		return qrVersion;
	}

	public void setQrVersion(int qrVersion) {
		this.qrVersion = qrVersion;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
