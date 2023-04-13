package Base.Funtionalities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class AllStuffRelatedToArraysAndItsTypes {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllStuffRelatedToArraysAndItsTypes.class);

    public static void newArrayTypes() {

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


    }



}
