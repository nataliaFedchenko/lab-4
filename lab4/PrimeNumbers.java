package primenumbers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PrimeNumbers extends Thread {

    public static void main(String[] args) {
        Calculate calc = new Calculate();
        for (int j = 0; j < nThr; j++) {
            Thread thread = new Thread(new Numbers(nThr, j, calc));
            thread.start();
        }
    }

    private static int nThr = 10;
}
