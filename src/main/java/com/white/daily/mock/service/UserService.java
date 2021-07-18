package com.white.daily.mock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.white.daily.mock.entity.User;

import java.util.List;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
public interface UserService extends IService<User> {

    List<User> getUserList();
}
