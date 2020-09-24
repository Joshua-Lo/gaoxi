package com.gaoxi.GaoxiUser;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class GaoxiUserApplicationTests {

    @Test
    void demo1() {
        String s = DigestUtils.md5DigestAsHex("123555".getBytes());
        System.out.println(s);
    }

}
