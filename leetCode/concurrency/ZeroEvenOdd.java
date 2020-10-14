package leetCode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    private int state = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!(state % 4 == 0 || state % 4 == 2)) {
                    zero.await();
                }
                state++;
                printNumber.accept(0);
                if (i % 2 == 0) {
                    odd.signal();
                } else {
                    even.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (state % 4 != 3) {
                    even.await();
                }
                state++;
                printNumber.accept(i);
                zero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (state % 4 != 1) {
                    odd.await();
                }
                state++;
                printNumber.accept(i);
                zero.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}