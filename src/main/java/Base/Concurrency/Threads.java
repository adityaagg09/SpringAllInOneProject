package Base.Concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {

    private static final Logger LOGGER = LoggerFactory.getLogger(Threads.class);

    public void threads() throws InterruptedException {

        // .start() will start a new thread and .run() will start the existing thread

        // Both of these threads have different id printing of lines is done by different threads
        Thread t = new Thread( () -> System.out.println(Thread.currentThread().getId()) );

        t.start();
        t.run();

        System.out.println(Thread.currentThread().getId()); // This is the main thread

        Thread t1 = new CustomThread();
        t1.start(); // It wil execute the

        Thread t2= new Thread(new RunThreadWhichImplementsRunnable());
        t2.start();
        t2.interrupt(); //To interrupt the sleep of the thread

        t2.join(500); // It will first execute the first thread and then it run the next thread and will wait for the given time which we pass in

        Thread t3= new Thread(new RunThreadWhichImplementsRunnable());
        t3.start();

        // T2 & T3 thread will be running in the parallel


        // To make code synchronised
        for(int i=0;i<10;i++) {
            print(); // It will not be synchronised to make it we need to add keyword synchronized
        }

        for(int i=0;i<10;i++) {
            print1();
        }

    }

    public static int count = 0;

    public static Object lock = new Object(); // This object has to be available for all the threads

    public static Lock lock1 = new ReentrantLock();

    // In this threads are not in order any thread can go in any manner
    public synchronized void print() {  // By synchronized one thread will access this function at a time
        synchronized (this) { // We can write this or object both will work to acquire lock on it
            int current = count;
            LOGGER.info("Before: {}  Thread id : {}", current, Thread.currentThread().getId());
            current += 1;
            LOGGER.info("After: {}  Thread id : {}", current, Thread.currentThread().getId());
        }
    }

    // Reentrant lock uses the FIFO principal meaning threads are in order
    public synchronized void print1() {
        if(lock1.tryLock()) {
            try {
                LOGGER.info("Lock can be acquired or not ? : {}", lock1.tryLock(500, TimeUnit.HOURS)); // It will return t/f depending upon lock can be acquired or not ?
                lock1.lock(); // It will lock and we need to do unlock else it will ifinite
                int current = count;
                LOGGER.info("Before: {}  Thread id : {}", current, Thread.currentThread().getId());
                current += 1;
                LOGGER.info("After: {}  Thread id : {}", current, Thread.currentThread().getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock1.unlock(); // So that we will unlock it irrespective of anything
            }
        }
    }



}
