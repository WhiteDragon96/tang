package com.white.daily.mock.service.impl;

import com.white.daily.mock.entity.Account;
import com.white.daily.mock.mapper.AccountMapper;
import com.white.daily.mock.service.IAccountService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.white.daily.mock.vo.AccountVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *  服务实现类
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

	@Override
	public IPage<AccountVO> selectAccountPage(IPage<AccountVO> page, AccountVO account) {
		return page.setRecords(baseMapper.selectAccountPage(page, account));
	}

}
