package Base.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsService {

    private static ExecutorService executorsService1 = Executors.newSingleThreadExecutor();

    private static ExecutorService executorService2 = Executors.newFixedThreadPool(3);

    private static ExecutorService executorService3 = Executors.newCachedThreadPool();

    private static ScheduledExecutorService executorService4 = Executors.newScheduledThreadPool(50);

    public void ExceuterServiceClass() throws ExecutionException, InterruptedException, TimeoutException {

        // SingleThreadPool ( 1 thread )  && SingleThreadScheduledExecutor ( 1 thread, b/w start & end there is some delay )


        // It will print only one single thread id
        ExecutorService executorsService = Executors.newSingleThreadExecutor(); // It will queue up all and will execute one by one
        executorsService.execute(() -> System.out.println("1" + Thread.currentThread().getId()));
        executorsService.execute(() -> System.out.println("1" + Thread.currentThread().getId()));
        executorsService.execute(() -> System.out.println("1" + Thread.currentThread().getId()));
        executorsService.execute(() -> System.out.println("1" + Thread.currentThread().getId()));

        List<Callable<Integer>> callableList = new ArrayList<>();
        callableList.add(() -> 1);
        callableList.add(() -> 2);
        callableList.add(() -> 3);

        executorsService.invokeAny(callableList); // It will invoke any of the values present in the list

        executorsService.invokeAll(callableList); // It will invoke all the values present in the list

        executorsService.shutdown(); // If we don't it will go in infinte loop

        Future<Double> doubleFuture = getRandomForSingleThreadPool(1);
        getRandomForSingleThreadPool(2);
        getRandomForSingleThreadPool(3);
        System.out.println(doubleFuture);


        doubleFuture.cancel(true); // Tries to cancel the task, true; if it's running then still cancel the task
        doubleFuture.isDone(); // Return true if task is completed successfully
        doubleFuture.isCancelled(); // Return true is task is cancelled
        doubleFuture.get(); // Will wait till result is not computed
        doubleFuture.get(1000, TimeUnit.HOURS); // Will wai until this timeperiod after that it will break
        executorsService1.shutdown();


        // FixedThreadPool ( n threads will remain whether it is  )

        for(int i=0;i<100;i++)
                getRandomForFixedThreadPool(i);
        executorService2.shutdown(); // To close all the threads

        // CachedThreadPool ( It will creates threads based on the needs and delete once is done )

        for(int i=0;i<100;i++)
            getRandomForCachedThreadPool(i);
        executorService3.shutdown();


        // ScheduledExecutorService ()
        for(int i=0;i<100;i++) {
            Future<Double> doubleFuture1 = getRandomForScheduledExecutorService(i);
            doubleFuture1.get(); // It will block this thread until future result gets in
            doubleFuture1.get(100, TimeUnit.MILLISECONDS); // It will wait till this time then will throw timeout
        }
        executorService4.shutdown();

    }

    public static Future<Double> getRandomForScheduledExecutorService(int i) {
        return executorService4.schedule(() -> {
            System.out.println(i + "Thread id: " + Thread.currentThread().getId()  );
            Thread.sleep(1000);
            return Math.random();
        }, 1000, TimeUnit.MILLISECONDS); // It will start execution after this time we passed in
    }

    public static Future<Double> getRandomForCachedThreadPool(int i) {
        return executorService3.submit(() -> {
            System.out.println(i + "Thread id: " + Thread.currentThread().getId()  );
            Thread.sleep(1000);
            return Math.random();
        });
    }

    public static Future<Double> getRandomForFixedThreadPool(int i) {
        return executorService2.submit(() -> {
            System.out.println(i + "Thread id: " + Thread.currentThread().getId()  );
            Thread.sleep(1000);
            return Math.random();
        });
    }

    public static Future<Double> getRandomForSingleThreadPool(int i) {
        return executorsService1.submit(() -> {
            System.out.println(i);
            Thread.sleep(1000);
            return Math.random();
        });
    }

}
