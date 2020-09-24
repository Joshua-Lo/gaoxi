package com.gaoxi.GaoxiUser.mapper;

import com.gaoxi.GaoxiUser.domain.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface UserMapper extends MyMapper<User> {
    User getUser(@Param("username")String username,@Param("password")String password);

    User selectByName(@Param("username") String username);
}