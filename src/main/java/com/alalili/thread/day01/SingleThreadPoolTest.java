package com.alalili.thread.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2021-12-20 17:27
 */
public class SingleThreadPoolTest {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100000; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("时间：" + (end - start)+ "毫秒");
        System.out.println("数量：" + list.size());
    }
}
