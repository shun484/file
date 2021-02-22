package com.order_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class OrderServerApplicationTests {

    @Test
    void contextLoads() {

        AtomicInteger integer = new AtomicInteger();
        System.out.println(integer);

        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println(atomicBoolean);

        AtomicBoolean atomicBoolean1 = new AtomicBoolean();
        System.out.println(atomicBoolean1);
    }

}
