package com.gaoxi.GaoxiUser.service;

import com.gaoxi.GaoxiUser.config.R;
import com.gaoxi.GaoxiUser.domain.User;
import com.gaoxi.GaoxiUser.vo.LoginParam;

public interface UserService {
    R checkRepeat(User user);

    R insert(User user);

    R getUser(LoginParam param);


}
