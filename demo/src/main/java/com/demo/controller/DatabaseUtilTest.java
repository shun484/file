package com.demo.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DatabaseUtilTest{


    static class Productor extends Thread{
        private Warehouse warehouse = null;

        public Productor(Warehouse warehouse) {
            super();
            this.warehouse = warehouse;
        }

        @Override
        public void run() {
            warehouse.pushProduct();
        }

    }

    static class Consumer extends Thread{

        private Warehouse warehouse = null;

        public Consumer(Warehouse warehouse) {
            super();
            this.warehouse = warehouse;
        }

        @Override
        public void run() {
            warehouse.popProduct();
        }
    }

    static class Warehouse {

        private LinkedList<Map<String,Object>> warehouse = new LinkedList();

        // 放10个产品
        public synchronized void pushProduct() {
            for (int i = 0; i<=10 ; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("name",i);
                push(map);
            }
        }

        // 消费10个产品
        public synchronized void popProduct() {
            for (int i = 0;i<=10 ; i++) {
                pop();
            }

        }


        // 向仓库放产品
        private void push(Map<String, Object> map) {
            // 当仓库中存放了10个产品就等待并通知消费者来消费
            if (warehouse.size() == 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }// 等待并释放当前资源的锁
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            warehouse.addFirst(map);
            System.out.println("放入仓库：" + map.get("name"));
            notify();// 通知消费者来消费
        }

        // 向仓库中取产品
        private void pop() {
            // 当仓库中产品为0时就等待并通知生产者来生产
            if (warehouse.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }// 等待并释放当前资源的锁
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String, Object> objectMap = warehouse.removeFirst();
            System.out.println("取出仓库：" + objectMap.get("name"));
            notify();// 通知生产者来生产
        }
    }
    public static void main(String[] args) {
        Warehouse warehouse=new Warehouse();
        Productor productor=new Productor(warehouse);
        Consumer consumer=new Consumer(warehouse);
        productor.start();
        consumer.start();
    }

}
