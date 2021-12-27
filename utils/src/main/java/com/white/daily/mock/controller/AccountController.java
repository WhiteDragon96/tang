package com.white.daily.mock.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.white.daily.constant.api.R;
import com.white.daily.constant.support.Condition;
import com.white.daily.constant.support.Query;
import com.white.daily.guava.GuavaTest;
import com.white.daily.mock.entity.Account;
import com.white.daily.mock.mapper.AccountMapper;
import com.white.daily.mock.service.IAccountService;
import com.white.daily.mock.vo.AccountVO;
import com.white.daily.thread.executor.AsyncService;
import com.white.daily.util.Func;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 控制器
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@RestController
@AllArgsConstructor
@RequestMapping("blade-demo/account")
@Api(value = "", tags = "接口")
public class AccountController {

    private final IAccountService accountService;

    private final AccountMapper accountMapper;
    private final AsyncService asyncService;
    private final GuavaTest guavaTest;

    /**
     * 详情
     */
    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "传入account")
    public R<Account> detail( Account account) {
        Account detail = accountService.getOne(Condition.getQueryWrapper(account));
        return R.data(detail);
    }

    /**
     * 分页
     */
    @GetMapping("/list")
    @ApiOperation(value = "分页", notes = "传入account")
    public List<Account> list(Account account, Query query) {
//        IPage<Account> pages = accountService.page(Condition.getPage(query), Condition.getQueryWrapper(account));
        return accountMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 自定义分页
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入account")
    public R<List<AccountVO>> page(AccountVO account, Query query) {
//        IPage<AccountVO> pages = accountService.selectAccountPage(Condition.getPage(query), account);
        List<AccountVO> accountVOS = accountMapper.selectAccountPage(Condition.getPage(query), account);

        return R.data(accountVOS);
    }

    /**
     * 新增
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入account")
    public R save(@Valid @RequestBody Account account) {
        return R.status(accountService.save(account));
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入account")
    public R update(@Valid @RequestBody Account account) {
        return R.status(accountService.updateById(account));
    }

    /**
     * 新增或修改
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入account")
    public R submit(@Valid @RequestBody Account account) {
        return R.status(accountService.saveOrUpdate(account));
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ApiOperation(value = "删除", notes = "传入ids")
    public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(accountService.removeByIds(Func.toLongList(ids)));
    }

    @GetMapping("/test")
    public boolean async(){
        return true;
    }
}
