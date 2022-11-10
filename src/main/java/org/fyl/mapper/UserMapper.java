package org.fyl.mapper;

import org.apache.ibatis.annotations.Param;
import org.fyl.pojo.User;

public interface UserMapper {
    User selectUser(
            @Param("userId")
                    String userId,
            @Param("userPassword")
                    String userPassword);
}
