package com.white.daily.mock.mapper;

import com.white.daily.mock.entity.Cnarea2018;
import com.white.daily.mock.vo.Cnarea2018VO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * 中国行政地区表 Mapper 接口
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
public interface Cnarea2018Mapper extends BaseMapper<Cnarea2018> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param cnarea2018
	 * @return
	 */
	List<Cnarea2018VO> selectCnarea2018Page(IPage page, Cnarea2018VO cnarea2018);

}
