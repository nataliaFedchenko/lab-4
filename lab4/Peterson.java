package primenumbers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Peterson implements Lock {

    private volatile boolean[] flag;

    public Peterson(int n, int threadId) {
        flag = new boolean[n]; 
        this.threadId = threadId;
    }
    private volatile int victim;
    private int threadId;

    @Override
    public void lock() {
        try {
            int i = threadId;
            int j = flag.length - 1 - i;
            flag[i] = true;
            victim = i;
            synchronized (flag) {
                while (flag[j] && victim == i) {
                    flag.wait();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void unlock() {
        synchronized (flag) {
            int i = threadId;
            flag[i] = false;
            flag.notifyAll();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean tryLock() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
