package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.DemoUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tangcs
 * @date since 2024-10-18
 */
@Mapper
public interface DemoUserMapper extends BaseMapper<DemoUser> {

    DemoUser selectByName(String name);
}
