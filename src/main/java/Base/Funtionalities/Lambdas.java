package Base.Funtionalities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Lambdas {

    private static final Logger LOGGER = LoggerFactory.getLogger(Lambdas.class);

    public interface Suppliers<T> { // Doesn't take anything produce something
        T get();
    }

    public interface Consumers<T> { // Take something but doesn't produce anything
        void accept(T t);
    }

    public interface Predicate<T> { // Takes something and return boolean
        boolean test(T t);
    }

    public interface Function<T, R> { // Take something and return something else
        R apply(T t);
    }

//    public class Printing implements Suppliers, Consumers {
//
//        public Object get() {
//            return null;
//        }
//
//        public void accept(Object o) {
//
//        }
//    }

    public static void Map() {

        // Suppliers
        Suppliers<String> suppliers = () ->  {
            System.out.println("We can write any lines of code here");
            return "Hello";
        };
        String value = suppliers.get();

        // Consumers
        Consumers<String> getStringValue2 = (String t) -> {
            // So here we can write any number of lines here
            System.out.println(t);
        };
        getStringValue2.accept("Hello Hello");


        // Predicates
        List<String> test1 = Arrays.asList("11","2","13","4","15","6","17");
        test1.removeIf((String x) -> x.startsWith("1"));
        test1.forEach((String x) -> System.out.println(x));

        // If else in lambdas functions
        List<String> filteredValues = new ArrayList<>();
        test1.forEach( values -> {
                if(values.startsWith("2")) {
                    filteredValues.add(values);
                } else {
                    System.out.println("Value doesn't satisfies the criteria");
                }
        });

        // Sorting of string
        List<String> unorderedList = Arrays.asList("2","1","4","3");
        unorderedList.sort((s1,s2) -> s1.compareTo(s2) );
        System.out.println(unorderedList);

        // Like this we can do the nested comparators if needed
        Comparator<String> comparator = Comparator.comparing(x -> x.length());
        Comparator<String> comparator1 = Comparator.comparing(x -> x.length());
        unorderedList.sort(comparator1.thenComparing(comparator1));


        // Map
        Map<String, Integer> prices = new TreeMap<>();
        prices.put("Apple", 1);
        prices.put("Avocado", 2);
        prices.put("Banana", 1);
        prices.put("Mango", 2);
        prices.put("Starfruit", 4);
        prices.forEach((key, values) -> System.out.println("Fruit: " + key + ", $" + values));

    }
}