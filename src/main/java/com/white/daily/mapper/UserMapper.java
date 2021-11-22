package com.white.daily.mapper;

import com.white.daily.mock.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    void addUserList(@Param("users") List<User> users);

    void insert(@Param("user") User user);

    List<User> selectUser(User user);
}
