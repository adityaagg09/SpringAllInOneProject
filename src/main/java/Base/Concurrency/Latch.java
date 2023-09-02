package Base.Concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class Latch {

    private static final Logger LOGGER = LoggerFactory.getLogger(Latch.class);

    public void latchFuntionality() throws InterruptedException {

        ExecutorService executorsService = Executors.newFixedThreadPool(4);

        // When we want our main thread to wait unless we have intialized something
        // By using a CountDownLatch we can cause a thread to block until other threads have completed a given task
        CountDownLatch countDownLatch  = new CountDownLatch(3); // This number signify after how many countDown we can proceed

        executorsService.submit(doSomethingAndLatchCountDown(countDownLatch));
        executorsService.submit(doSomethingAndLatchCountDown(countDownLatch));
        executorsService.submit(doSomethingAndLatchCountDown(countDownLatch));



        countDownLatch.await();

        LOGGER.info("latchFuntionality(): Latch await has been done");


    }

    public Runnable doSomethingAndLatchCountDown(CountDownLatch countDownLatch) {
        LOGGER.info("doSomethingAndLatchCountDown(): Current count of latch is: {}", countDownLatch.getCount());
        countDownLatch.countDown();
        LOGGER.info("doSomethingAndLatchCountDown(): Count after countDown is: {}", countDownLatch.getCount());
        return null;
    }


}
