package com.white.daily.mock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.white.daily.mock.entity.Account;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.white.daily.mock.vo.AccountVO;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
public interface AccountMapper extends BaseMapper<Account> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param account
	 * @return
	 */
	List<AccountVO> selectAccountPage(IPage page, AccountVO account);

}
