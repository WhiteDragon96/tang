package com.white.daily.mapper;

import com.white.daily.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
@Mapper
public interface UserMapper {

    /**
     *获取所有user
     *
     * @return result
     */
    List<User> selectUserList();
}
