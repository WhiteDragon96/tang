package com.white.daily.mock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.white.daily.mock.entity.Cnarea2018;
import com.white.daily.mock.vo.Cnarea2018VO;
import com.white.daily.mock.service.ICnarea2018Service;

/**
 * 中国行政地区表 控制器
 *
 * @author WhiteDragon
 * @since 2021-05-13
 */
@RestController
@AllArgsConstructor
@RequestMapping("MyUtils/cnarea2018")
@Api(value = "中国行政地区表", tags = "中国行政地区表接口")
public class Cnarea2018Controller {

	private final ICnarea2018Service cnarea2018Service;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入cnarea2018")
	public R<Cnarea2018> detail(Cnarea2018 cnarea2018) {
		Cnarea2018 detail = cnarea2018Service.getOne(Condition.getQueryWrapper(cnarea2018));
		return R.data(detail);
	}

	/**
	 * 分页 中国行政地区表
	 */
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入cnarea2018")
	public R<IPage<Cnarea2018>> list(Cnarea2018 cnarea2018, Query query) {
		IPage<Cnarea2018> pages = cnarea2018Service.page(Condition.getPage(query), Condition.getQueryWrapper(cnarea2018));
		return R.data(pages);
	}

	/**
	 * 自定义分页 中国行政地区表
	 */
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入cnarea2018")
	public R<IPage<Cnarea2018VO>> page(Cnarea2018VO cnarea2018, Query query) {
		IPage<Cnarea2018VO> pages = cnarea2018Service.selectCnarea2018Page(Condition.getPage(query), cnarea2018);
		return R.data(pages);
	}

	/**
	 * 新增 中国行政地区表
	 */
	@PostMapping("/save")
	@ApiOperation(value = "新增", notes = "传入cnarea2018")
	public R save(@Valid @RequestBody Cnarea2018 cnarea2018) {
		return R.status(cnarea2018Service.save(cnarea2018));
	}

	/**
	 * 修改 中国行政地区表
	 */
	@PostMapping("/update")
	@ApiOperation(value = "修改", notes = "传入cnarea2018")
	public R update(@Valid @RequestBody Cnarea2018 cnarea2018) {
		return R.status(cnarea2018Service.updateById(cnarea2018));
	}

	/**
	 * 新增或修改 中国行政地区表
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入cnarea2018")
	public R submit(@Valid @RequestBody Cnarea2018 cnarea2018) {
		return R.status(cnarea2018Service.saveOrUpdate(cnarea2018));
	}


	/**
	 * 删除 中国行政地区表
	 */
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(cnarea2018Service.removeByIds(Func.toLongList(ids)));
	}


}
