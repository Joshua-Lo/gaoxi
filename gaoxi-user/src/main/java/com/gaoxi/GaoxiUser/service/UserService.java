package com.gaoxi.GaoxiUser.service;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.User;
import com.gaoxi.GaoxiUser.vo.LoginParam;

public interface UserService {
    User checkRepeat(User user);

    Integer insert(User user);

    User getUser(LoginParam param);


}
