package com.white.daily.mock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 实体类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@Data
@ApiModel(value = "Account对象", description = "Account对象")
@TableName("account")
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable,Comparable<Account>{

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.ID_WORKER)
	private Long id;
	private String name;
	private Double money;


	@Override
	public int compareTo(Account o) {
		return Double.compare(this.money,o.getMoney());
	}
}
