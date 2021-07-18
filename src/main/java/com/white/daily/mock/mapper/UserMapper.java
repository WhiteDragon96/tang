package com.white.daily.mock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.white.daily.mock.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     *获取所有user
     *
     * @return result
     */
    List<User> selectUserList();

    void addUserList(@Param("users") List<User> users);

    int insert(@Param("user") User user);

    List<User> selectUser(User user);
}
