package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String str = "原图";
        String md5Str = DigestUtils.md5DigestAsHex(str.getBytes());

        System.out.println(md5Str+str);
    }

}
