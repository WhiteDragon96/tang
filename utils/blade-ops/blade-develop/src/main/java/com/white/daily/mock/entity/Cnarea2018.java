package com.white.daily.mock.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 中国行政地区表实体类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@Data
@ApiModel(value = "Cnarea2018对象", description = "中国行政地区表")
public class Cnarea2018 implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	/**
	* 层级
	*/
	@ApiModelProperty(value = "层级")
	private Boolean level;
	/**
	* 父级行政代码
	*/
	@ApiModelProperty(value = "父级行政代码")
	private Long parentCode;
	/**
	* 行政代码
	*/
	@ApiModelProperty(value = "行政代码")
	private Long areaCode;
	/**
	* 邮政编码
	*/
	@ApiModelProperty(value = "邮政编码")
	private Integer zipCode;
	/**
	* 区号
	*/
	@ApiModelProperty(value = "区号")
	private String cityCode;
	/**
	* 名称
	*/
	@ApiModelProperty(value = "名称")
	private String name;
	/**
	* 简称
	*/
	@ApiModelProperty(value = "简称")
	private String shortName;
	/**
	* 组合名
	*/
	@ApiModelProperty(value = "组合名")
	private String mergerName;
	/**
	* 拼音
	*/
	@ApiModelProperty(value = "拼音")
	private String pinyin;
	/**
	* 经度
	*/
	@ApiModelProperty(value = "经度")
	private BigDecimal lng;
	/**
	* 纬度
	*/
	@ApiModelProperty(value = "纬度")
	private BigDecimal lat;


}
