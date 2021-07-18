package com.white.daily.mock.service;

import com.white.daily.mock.entity.Cnarea2018;
import com.white.daily.mock.vo.Cnarea2018VO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 中国行政地区表 服务类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
public interface ICnarea2018Service extends IService<Cnarea2018> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param cnarea2018
	 * @return
	 */
	IPage<Cnarea2018VO> selectCnarea2018Page(IPage<Cnarea2018VO> page, Cnarea2018VO cnarea2018);

}
