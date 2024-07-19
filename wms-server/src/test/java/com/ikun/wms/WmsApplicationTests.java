package com.ikun.wms;

import com.ikun.wms.mapper.AuthInfoMapper;
import com.ikun.wms.pojo.dto.AuthTree;
import com.ikun.wms.service.AuthInfoService;
import com.ikun.wms.utils.JWTUtils;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class WmsApplicationTests {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private AuthInfoMapper authInfoMapper;
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

    @Test
    public void test1() {
        List<AuthTree> authTreeByUserId = authInfoMapper.getAuthTreeByUserId();
        authTreeByUserId.forEach(authTree -> {
            System.out.println(authTree.getAuthName()+"  "+authTree.getAuthUrl());
            System.out.println(authTree.getChildAuth());
            System.out.println("-------");
        });
//        System.out.println(authTreeByUserId);
    }
}
