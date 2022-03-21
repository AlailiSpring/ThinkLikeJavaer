package com.alaili.java.lock;


import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock方法调用示例
 */
public class ReentrantLockDemo {

    private static ReentrantLock rLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        BaseMerchant merchantRunnable = new MerchantRunnableUnSafe();

        for (int i = 0; i < 1000; i++) {
            Thread client = new Thread(merchantRunnable);
            client.setName("Client-" + i);
            client.start();
        }
        Thread.sleep(2000);
        System.out.println("今天的营业总额是:" + merchantRunnable.getTodayRMB());

    }

    public static class MerchantRunnableUnSafe extends BaseMerchant {
        @Override
        public void run() {
            rLock.lock();
            //rLock.tryLock();
            //rLock.tryLock(10, TimeUnit.SECONDS);
            try {
                Thread.sleep(1);
                long temp = todayRMB;
                long update = temp + 10;
                todayRMB = update;
                System.out.println(Thread.currentThread().getName() + "_todayRMB:" + todayRMB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                rLock.unlock();
            }
        }
    }

    //static和abstract可以同时修饰一个类
    public static abstract class BaseMerchant implements Runnable {
        protected volatile long todayRMB = 0L;
        public long getTodayRMB() {
            return todayRMB;
        }
    }
}