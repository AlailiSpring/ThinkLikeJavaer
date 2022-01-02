package com.alalili.java.thread.day02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2022-01-02 23:23
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        Long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            executorService3.execute(new MyTaskRunnable(i));
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("消耗时间为："+(endTime-startTime)+"毫秒");
    }

}
