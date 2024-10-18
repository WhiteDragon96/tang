
package com.white.daily.generate.entity;


import lombok.Data;

/**
 * 数据源配置表实体类
 *
 * @author tt
 */
@Data
public class Datasource{

	private static final long serialVersionUID = 1L;

	/**
	 * 名称
	 */
	private String name;
	/**
	 * 驱动类
	 */
	private String driverClass;
	/**
	 * 连接地址
	 */
	private String url;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 备注
	 */
	private String remark;


}
