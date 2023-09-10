package Base.Concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class LatchAndCyclicBarrier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LatchAndCyclicBarrier.class);

    public void latchFuntionality() throws InterruptedException {

        ExecutorService executorsService = Executors.newFixedThreadPool(4);

        // When we want our main thread to wait unless we have intialized something
        // By using a CountDownLatch we can cause a thread to block until other threads have completed a given task
        CountDownLatch countDownLatch  = new CountDownLatch(3); // This number signify after how many countDown we can proceed

        executorsService.submit(doSomethingAndLatchCountDown(countDownLatch));
        executorsService.submit(doSomethingAndLatchCountDown(countDownLatch));
        executorsService.submit(doSomethingAndLatchCountDown(countDownLatch));

        countDownLatch.await(); // When all the threads have done countdown then after that code below it will start executing

        LOGGER.info("latchFuntionality(): LatchAndCyclicBarrier await has been done");

        // In cyclic barrier all threads start at the same time and do task and wait for all the threads to arrive at same state then again start processing


        // Difference between countDownLatch and cyclicBarrier in latch all threads don't start at same time else in other they start at same time

    }

    public Runnable doSomethingAndLatchCountDown(CountDownLatch countDownLatch) {
        LOGGER.info("doSomethingAndLatchCountDown(): Current count of latch is: {}", countDownLatch.getCount());
        countDownLatch.countDown();
        LOGGER.info("doSomethingAndLatchCountDown(): Count after countDown is: {}", countDownLatch.getCount());
        return null;
    }


}
