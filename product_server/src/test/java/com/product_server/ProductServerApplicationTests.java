package com.product_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServerApplicationTests {

    private static final String USERLOGIN = "/user/login";
    @Test
    void contextLoads() {
        boolean fa = false;
        String a = "/user/login";
        if(a.equals(USERLOGIN)){
            fa = true;
        }

        System.out.println(fa);
    }

}
