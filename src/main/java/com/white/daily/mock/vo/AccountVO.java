package com.white.daily.mock.vo;

import com.white.daily.mock.entity.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 视图实体类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
	@Data
	@EqualsAndHashCode(callSuper = true)
	@ApiModel(value = "AccountVO对象", description = "AccountVO对象")
public class AccountVO extends Account {
	private static final long serialVersionUID = 1L;

}
