package com.dafengsu.ssm.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author su
 * @description
 * @date 2020/4/2
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:spring-security.xml","classpath*:applicationContext.xml"})
public class TestDemo {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    void testEncode() {
        System.err.println(bCryptPasswordEncoder.encode("123"));
    }
}
