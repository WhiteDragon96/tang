package com.white.daily.mock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;


/**
 * 实体类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@Data
@ApiModel(value = "Account对象", description = "Account对象")
@TableName("account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private Double money;


}
