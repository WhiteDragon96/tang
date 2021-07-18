package com.white.daily.mock.vo;

import com.white.daily.mock.entity.Cnarea2018;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 中国行政地区表视图实体类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
	@Data
	@EqualsAndHashCode(callSuper = true)
	@ApiModel(value = "Cnarea2018VO对象", description = "中国行政地区表")
public class Cnarea2018VO extends Cnarea2018 {
	private static final long serialVersionUID = 1L;

}
