package leetCode.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

//使用原子类太慢，会超时
public class FooBar {
    private int n;
    private AtomicInteger flag = new AtomicInteger(0);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (flag.get()%2!=0){
                Thread.yield();
            }
            printFoo.run();
            flag.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (flag.get()%2==0){
                Thread.yield();
            }
            printBar.run();
            flag.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Runnable printFoo = new Runnable() {

            @Override
            public void run() {
                System.out.println("foo");
            }
        };

        Runnable printBar = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };

        int n = 2;
        FooBar f = new FooBar(n);

        try {
            f.foo(printFoo);
            f.bar(printBar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}