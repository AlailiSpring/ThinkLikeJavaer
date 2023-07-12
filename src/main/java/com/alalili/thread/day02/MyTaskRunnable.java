package main.java.com.alalili.thread.day02;

/**
 * @Description:
 * @Author: LiBaoDeng
 * @Date: 2022-01-02 23:38
 */
public class MyTaskRunnable implements Runnable {
    private int i;

    MyTaskRunnable(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在做第【" + i + "】个项目");
    }
}
