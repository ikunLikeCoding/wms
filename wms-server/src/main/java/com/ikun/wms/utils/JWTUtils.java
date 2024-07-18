package com.ikun.wms.utils;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ikun.wms.pojo.entity.User;


import java.util.HashMap;
import java.util.Map;


/**
 * jwt工具类
 *
 */
public class JWTUtils<T> {


    public static final String SECRET = "asddas1123gwegqwd112";

    public static final Algorithm ALGORITHM_METHOD = Algorithm.HMAC256(SECRET);
    /**
     * 生成JWT （token）
     *
     */
    public static String createJWT(String userJSON) {
        //组装头数据
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        return JWT.create()
                //头部
                .withHeader(header)

                //负载
                .withClaim("user", userJSON)

                //签名
                .sign(ALGORITHM_METHOD);
    }

    /**
     * 验证JWT
     *
     * @param jwt 要验证的jwt的字符串
     */
    public static Boolean verifyJWT(String jwt) {
        try {
            // 使用秘钥创建一个JWT验证器对象
            JWTVerifier jwtVerifier = JWT.require(ALGORITHM_METHOD).build();

            //验证JWT，如果没有抛出异常，说明验证通过，否则验证不通过
            jwtVerifier.verify(jwt);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 解析JWT的数据
     *
     */
    public static <T> T parseJWT(String jwt,String key,Class<T> clazz) {
        try {
            // 使用秘钥创建一个验证器对象
            JWTVerifier jwtVerifier = JWT.require(ALGORITHM_METHOD).build();

            //验证JWT，得到一个解码后的jwt对象
            DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
            Map<String, Claim> claims = decodedJWT.getClaims();
            Claim claim = claims.get(key);

            return JSONUtils.toBean(claim.asString(), clazz);
            //通过解码后的jwt对象，就可以获取里面的负载数据
//            for (String key : decodedJWT.getClaims().keySet()){
//                System.out.println(key + " : " + decodedJWT.getClaim(key).asString());
//            }

        } catch (TokenExpiredException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static User parseUserFromJWT(String jwt) {
        try {
            // 使用秘钥创建一个验证器对象
            JWTVerifier jwtVerifier = JWT.require(ALGORITHM_METHOD).build();

            //验证JWT，得到一个解码后的jwt对象
            DecodedJWT decodedJWT = jwtVerifier.verify(jwt);

            //通过解码后的jwt对象，就可以获取里面的负载数据
            Claim userClaim = decodedJWT.getClaim("user");

            String userJSON = userClaim.asString();

            return JSON.parseObject(userJSON, User.class);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
