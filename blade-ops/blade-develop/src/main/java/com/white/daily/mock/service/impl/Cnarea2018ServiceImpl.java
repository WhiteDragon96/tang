package com.white.daily.mock.service.impl;

import com.white.daily.mock.entity.Cnarea2018;
import com.white.daily.mock.vo.Cnarea2018VO;
import com.white.daily.mock.mapper.Cnarea2018Mapper;
import com.white.daily.mock.service.ICnarea2018Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 中国行政地区表 服务实现类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@Service
public class Cnarea2018ServiceImpl extends ServiceImpl<Cnarea2018Mapper, Cnarea2018> implements ICnarea2018Service {

	@Override
	public IPage<Cnarea2018VO> selectCnarea2018Page(IPage<Cnarea2018VO> page, Cnarea2018VO cnarea2018) {
		return page.setRecords(baseMapper.selectCnarea2018Page(page, cnarea2018));
	}

}
