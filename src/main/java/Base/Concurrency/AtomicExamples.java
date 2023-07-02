package Base.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExamples {

    private static AtomicInteger ai = new AtomicInteger();

    public void playWithAtomicIntegers() {

        ExecutorService executorsService = Executors.newFixedThreadPool(5);
        for(int i=0; i<10; i++) {
            executorsService.submit(() -> System.out.println(ai.incrementAndGet()));
        }
        executorsService.shutdown();

    }

}
