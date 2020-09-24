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

    @Override
    public R checkRepeat(User user) {
        User users = mapper.selectByName(user.getUsername());
        if (users!=null){
            return R.fail();
        }else {
            return R.ok(user);
        }

    }

    @Override
    public R insert(User user) {
        initUser(user);
        int insert = mapper.insert(user);
        if (insert>0){
            return R.ok(user);
        }else {
            return R.fail();
        }
    }

    @Override
    public R getUser(LoginParam param) {
        String password = DigestUtils.md5DigestAsHex(param.getPassword().getBytes());
        User user = mapper.getUser(param.getUsername(), password);
        if (user!=null){
            user.setLastlogintime(new Date());
            mapper.updateByPrimaryKey(user);
            System.out.println(user.getLastlogintime());
            return R.ok(user);
        }
        return R.fail();
    }

    private void initUser(User user) {
        user.setRegistertime(new Date());
        user.setLastlogintime(new Date());

        String encode = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

        user.setPassword(encode);

    }


}
