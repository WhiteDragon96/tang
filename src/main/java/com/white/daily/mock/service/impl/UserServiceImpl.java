package com.white.daily.mock.service.impl;

import com.white.daily.mapper.UserMapper;
import com.white.daily.mock.service.UserService;
import com.white.daily.pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectUserList();
    }
}
