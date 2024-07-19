package com.ikun.wms;

import com.ikun.wms.utils.JWTUtils;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class WmsApplicationTests {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    public void test() {
        String jwt = JWTUtils.createJWT("{\"username\":\"admin\",\"password\":\"123456\"}");
        System.out.println(jwt);
    }

}
