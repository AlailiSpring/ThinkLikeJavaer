package com.alalili.thread.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2021-12-20 17:13
 */
public class NormalThreadTest{
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<100000;i++){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start) + "毫秒");
        System.out.println("数量：" + list.size());
    }
}
