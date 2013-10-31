package primenumbers;

import java.util.concurrent.locks.Lock;

public class Numbers extends Thread {
    
    public Numbers(int thrNumb, int id, Calculate calc) {
        lock = new Peterson(thrNumb, id);
        this.calc = calc;
    }
    
    private Lock lock;
    Calculate calc;

    @Override
    public void run() {
        calc.PrimePrint(lock);
    }
}
