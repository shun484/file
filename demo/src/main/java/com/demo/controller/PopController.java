package com.demo.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PopController {
    public static void main(String[] args) {
        WordModel wordModel = new WordModel();
        Productor productor = new Productor(wordModel);
        Consumer consumer = new Consumer(wordModel);
        productor.start();
        consumer.start();
    }

    static class WordModel{
        private LinkedList<Map<String,Object>> wordModel = new LinkedList<>();

        public synchronized void pushModel() {

            for (int i = 0; i <=20 ; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("name",i);
               push(map);
            }
        }

        private void push(Map<String,Object> map){
            if(wordModel.size() == 10){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            wordModel.addFirst(map);
            System.out.println("通知消费"+map.get("name"));
            notify();
        }

        public synchronized void proModel() {

            if(wordModel.size() ==10){
                for (Map<String, Object> map : wordModel) {

                    pro(map.get("name"));
                }
            }
        }

        private synchronized void pro(Object name) {
            System.out.println(wordModel.size());
            if (wordModel.size() == 0){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("取出仓库"+name);
            notify();
        }
    }

    static class Productor extends  Thread{
        private WordModel wordModel = null;

        public Productor(WordModel wordModel){
            this.wordModel = wordModel;
        }

        @Override
        public void run(){
            wordModel.pushModel();
        }
    }

    static class Consumer extends Thread{
        private WordModel wordModel = null;
        public Consumer(WordModel wordModel){
            this.wordModel = wordModel;
        }
        @Override
        public void run(){
            wordModel.proModel();
        }
    }
}