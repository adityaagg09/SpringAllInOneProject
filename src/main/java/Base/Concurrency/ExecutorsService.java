package Base.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsService {

    public void ExceuterServiceClass() throws ExecutionException, InterruptedException {

        // It will print only one single thread id
        ExecutorService executorsService = Executors.newSingleThreadExecutor();
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

    }

}
