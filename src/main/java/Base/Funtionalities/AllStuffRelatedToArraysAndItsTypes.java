package Base.Funtionalities;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;

public class AllStuffRelatedToArraysAndItsTypes {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllStuffRelatedToArraysAndItsTypes.class);

    public static void newArrayTypes() throws InterruptedException {

        // We should never use the hashMap because it is the interface class for the map
        Map<String, String> map_ =  new HashMap<>();
        map_.put("Testing", "Tested");
        map_.put("Testing1", "Tested1");
        LOGGER.info("HashMap all values are : {} and key set : {}",map_.values(), map_.keySet());


        // It is basically set but internally uses the map data structure, but if print all elements then order is random
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("Hi");
        hashSet.add("Hello");

        LOGGER.info("Checking if value Hello exist in our hashSet or not ? : {}", hashSet.contains("Hello"));
        LOGGER.info("Checking if value Hello exist in our hashSet or not ? : {}", hashSet.contains("Hel"));
        LOGGER.info("Printing all the hashSet values : ");
        for(String val : hashSet) {
            LOGGER.info(val);
        }


        // It is basically set but internally uses the map data structure, but if print all elements then order is in which u inserted
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Hello");
        linkedHashSet.add("Hi");
        linkedHashSet.add("Hello");

        LOGGER.info("Checking if value Hello exist in our LinkedHashSet or not ? : {}", linkedHashSet.contains("Hello"));
        LOGGER.info("Checking if value Hello exist in our LinkedHashSet or not ? : {}", linkedHashSet.contains("Hel"));
        LOGGER.info("Printing all the LinkedHashSet values : ");
        for(String val : linkedHashSet) {
            LOGGER.info(val);
        }

        // It partitions the array in the given size of input
        List<String> list = Arrays.asList("1","2","3","4","5");
        List<List<String>> partitionLists = Lists.partition(list,2);
        LOGGER.info("Size of Partitioned list is : {}", partitionLists.size());
        for(List<String> lists: partitionLists) {
            LOGGER.info("Partitioned list is: {}", lists);
        }


        // Concurrent Map
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Hello", "Pinka Paaji");

        // Blocking queue
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(); // Queue + Blocking queue
        blockingQueue.offer("Pinka");
        blockingQueue.offer("Paaji");
        blockingQueue.offer("Paaji2");
        // Special for concurrent queues
        blockingQueue.offer("Pratima", 100, TimeUnit.MILLISECONDS); // Will wait till this for getting inserted
        blockingQueue.poll(300, TimeUnit.MILLISECONDS); // Will wait till this much amount of time and if queue is not available returns false

        //




    }



}
