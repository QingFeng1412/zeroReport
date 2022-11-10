package org.fyl.service.impl;

import org.fyl.mapper.UserMapper;
import org.fyl.pojo.User;
import org.fyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(String userId, String userPassword) {
        return userMapper.selectUser(userId,userPassword);
    }
}
