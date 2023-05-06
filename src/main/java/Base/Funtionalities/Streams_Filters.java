package Base.Funtionalities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams_Filters {

    private static final Logger LOGGER = LoggerFactory.getLogger(Streams_Filters.class);

    public static void Filters() {
        List<String> test = Arrays.asList("11","2","13","4","15","6","17");

        List<String> result = test.stream().filter(x -> x.length()>1).collect(Collectors.toList());
        LOGGER.info("The resulted filter is: {}", result);
    }

    public static void Map() {
        List<List<String>> test = new ArrayList<>();

        List<String> test1 = Arrays.asList("11","2","13","4","15","6","17");
        List<String> test2 = Arrays.asList("15","2","13","4","15","6","17");
        List<String> test3 = Arrays.asList("211","2","13","4","15","6","17");
        test=Arrays.asList(test1, test2, test3);

        List<String> result = test.stream().map(x -> x.get(0)).collect(Collectors.toList());
        LOGGER.info("The resulted map is: {}", result);
    }

}
