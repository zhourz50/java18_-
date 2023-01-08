package com.example.springboot18.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;

public class JWTUtil {

    private final static String sec = "12323ksdjfiodjs";

    public static String getToken(Integer userId) {
        String token = JWT.create().withHeader(new HashMap<>()) //header
                .withClaim("userId", userId + "") //payload 存放我们需要的业务信息
//                .withExpiresAt(new Date(System.currentTimeMillis() + 1 * 1000 * 60)) //指定令牌的过期时间
                .sign(Algorithm.HMAC256(sec)); //签名， 密钥自己记住

        return token;
    }

    public static String getClaim(String key, String token) throws Exception{
        DecodedJWT jwtDecoded = JWT.require(Algorithm.HMAC256(sec)).build().verify(token);
        return jwtDecoded.getClaim(key).asString();
    }

}
