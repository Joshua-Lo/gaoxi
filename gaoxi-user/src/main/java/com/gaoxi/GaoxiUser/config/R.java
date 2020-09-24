package com.gaoxi.GaoxiUser.config;


import lombok.Data;

import java.io.Serializable;

/***
* @ClassName
* @Author luyingshan
* @Date 17:53
* @Version 1.0
*/
@Data
public class R  implements Serializable {
    public int code;
    public String msg;
    public Object data;
    public  R(int code,String msg,Object data) {
        this.code=code;
        this.data=data;
        this.msg=msg;
    }
    public R() {

    }
}
