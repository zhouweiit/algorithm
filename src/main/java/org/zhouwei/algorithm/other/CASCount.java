package org.zhouwei.algorithm.other;

/**
 *
 * cas是一个CPU指令集，这个例子由于调用不了cas，所以用悲观锁实现了这个
 *
 * Created by zhouwei on 2018/5/23.
 */
public class CASCount implements Runnable {

    private SimilatedCAS counter = new SimilatedCAS();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(this.increment());
        }
    }

    public int increment() {
        int oldValue = counter.getValue();
        int newValue = oldValue + 1;

        while (!counter.compareAndSwap(oldValue, newValue)) { //如果CAS失败,就去拿新值继续执行CAS
            oldValue = counter.getValue();
            newValue = oldValue + 1;
        }

        return newValue;
    }

    public static void main(String[] args) {
        Runnable run = new CASCount();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }
}

class SimilatedCAS {

    private int value;

    public int getValue() {
        return value;
    }

    // 这里只能用synchronized了,毕竟无法调用操作系统的CAS
    public synchronized boolean compareAndSwap(int expectedValue, int newValue) {
        if (value == expectedValue) {
            value = newValue;
            return true;
        }
        return false;
    }

}
