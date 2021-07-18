package com.white.daily.mock.service;

import com.white.daily.mock.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.white.daily.mock.vo.AccountVO;

/**
 *  服务类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
public interface IAccountService extends IService<Account> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param account
	 * @return
	 */
	IPage<AccountVO> selectAccountPage(IPage<AccountVO> page, AccountVO account);

}
