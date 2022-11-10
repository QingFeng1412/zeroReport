package org.fyl.service;

import org.apache.ibatis.annotations.Param;
import org.fyl.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User selectUser(String userId, String userPassword);
}
