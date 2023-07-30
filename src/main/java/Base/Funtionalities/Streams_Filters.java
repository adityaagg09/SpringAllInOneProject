package Base.Funtionalities;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_Filters {

    private static final Logger LOGGER = LoggerFactory.getLogger(Streams_Filters.class);

    public static void Filters() {
        List<String> test = Arrays.asList("11","2","13","4","15","6","17");

        List<String> result = test.stream().filter(x -> x.length()>1).collect(Collectors.toList());
        LOGGER.info("The resulted filter is: {}", result);
    }

    public static void Map() {
        List<List<String>> test = new ArrayList<>();

        List<String> test1 = Arrays.asList("11","2","4","4","15","6","17");
        List<String> test2 = Arrays.asList("15","2","13","4","15","6","17");
        List<String> test3 = Arrays.asList("211","2","13","4","15","6","17");
        test=Arrays.asList(test1, test2, test3);
        List<List<String>> test4=Arrays.asList(Arrays.asList("12","12"), Arrays.asList("21","45"));

        // Lambdas functions
        Map<String, List<String>> map4_ = new HashMap<>();
        test1.forEach(x -> map4_.computeIfAbsent(x, y -> new ArrayList<>()).add("123"));

        // Collecting results
        List<String> result = test.stream().map(x -> x.get(0)).collect(Collectors.toList());
        String result7 = test.stream().map(x -> x.get(0)).collect(Collectors.joining("_#"));

//        Map<String, String > map_  = test1.stream().collect(Collectors.toMap(
//                test2.get(0),
//                test2.get(1)));
                // (x1, y1) -> (x1 + "," + y1) )); // Merge functions if 2 same key exists then


        // We can group by to a list by a particular values it will group by the on the object which stream is getting created
        Map<String, List<String>> map1_ = test1.stream().collect(Collectors.groupingBy(x -> x+"_#")); // Inside the grouping by will be the first parameter of our map

        //In this we first group on the first index of the array elements and then we do mapping which thing we want and then we do the final result return type
        Map<String, List<String>> map2_ = test4.stream().collect(Collectors.groupingBy(x -> x.get(0), Collectors.mapping(x -> x.get(1), Collectors.toList())));

        // Partioning  this get all the true and false based on the condition which we have passed
        Map<Boolean, List<String>> map3_ = test1.stream().collect(Collectors.partitioningBy(product -> product.equalsIgnoreCase("123")));

        // Collecting results 2
        Optional<String> result8 = test1.stream().reduce((resultt,y) -> resultt+=y ); // Here we get our concatinated string in resultt
        result8.ifPresentOrElse( // Present in optional only
                sum -> System.out.println(sum),  // If condition
                () -> System.out.println("Value is not present") // Else condition
        );

        String result9 = test1.stream().reduce(StringUtils.EMPTY, (resultt1,y1) -> resultt1+=y1 ); // It takes this as the initial value and return the strinf


        // Finding elements in the stream
        Optional<String> result2  = test2.stream().filter(x -> x.equalsIgnoreCase("13"))
                        .findAny();
        Optional<String> result3  = test2.stream().filter(x -> x.equalsIgnoreCase("13"))
                .findFirst(); // Returns the first matching elements valid if elements are in the sorted order

        // orElse statement result not for the Optional<> statement
        String result10 = test2.stream().filter(x -> x.equalsIgnoreCase("4")).findAny().orElse("Returning Else");

        boolean result4  = test2.stream().anyMatch(x -> x.equalsIgnoreCase("13"));

        boolean result5  = test2.stream().allMatch(x -> x.equalsIgnoreCase("13"));

        boolean result6  = test2.stream().noneMatch(x -> x.equalsIgnoreCase("13"));

        // Iterating over streams
        Stream<Character> alphabets = Stream.iterate('A', letter -> letter<='Z', letter -> (char)(letter+1) );

        LOGGER.info("The resulted map is: {}", result);
    }

}
