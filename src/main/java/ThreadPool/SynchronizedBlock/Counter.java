package ThreadPool.SynchronizedBlock;

public class Counter {
    int counter = 0;
    Object object1 = new Object();

    public void incrementCounter() {
       synchronized (object1) {
           this.counter +=10;
       }
    }

    public int getCounter() {
        return this.counter;
    }
}
