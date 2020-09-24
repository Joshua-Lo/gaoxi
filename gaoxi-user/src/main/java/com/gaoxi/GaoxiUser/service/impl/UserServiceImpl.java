package com.gaoxi.GaoxiUser.service.impl;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.User;
import com.gaoxi.GaoxiUser.mapper.UserMapper;
import com.gaoxi.GaoxiUser.service.UserService;
import com.gaoxi.GaoxiUser.vo.LoginParam;
import org.apache.tomcat.util.security.MD5Encoder;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author luyingshan 卢
 * @Date 2020/9/22
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    /**
     * @date 17:39
     * @MethodName checkRepeat 根据用户名查询是否有重名的用户
     * @param
     * @param user
     * @return com.gaoxi.GaoxiUser.domain.User
     */
    @Override
    public User checkRepeat(User user) {
        User users = mapper.selectByName(user.getUsername());
        if (users!=null){
            return users;
        }
        return null;
    }

    /**
     * @date 17:40
     * @MethodName insert 注册添加用户
     * @param user
     * @return java.lang.Integer
     */
    @Override
    public Integer insert(User user) {
        initUser(user);
        int insert = mapper.insert(user);
        if (insert>0){
            return insert;
        }else {
            return 0;
        }
    }

    /**
     * @date 17:40
     * @MethodName getUser 根据用户名密码查询用户
     * @param
     * @param param
     * @return com.gaoxi.GaoxiUser.domain.User
     */
    @Override
    public User getUser(LoginParam param) {
        String password = DigestUtils.md5DigestAsHex(param.getPassword().getBytes());
        User user = mapper.getUser(param.getUsername(), password);
        if (user!=null){
            user.setLastlogintime(new Date());
            mapper.updateByPrimaryKey(user);
            System.out.println(user.getLastlogintime());
            return user;
        }
        return null;
    }

    private void initUser(User user) {
        user.setRegistertime(new Date());
        user.setLastlogintime(new Date());

        String encode = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

        user.setPassword(encode);

    }


}
