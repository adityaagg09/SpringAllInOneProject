package Base.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// ImportResource used to load bean configurations from the xml file + Can be used only where @Configuration annotation is used

//@Configuration
//@org.springframework.context.annotation.ImportResource("classpath:location of the bean xml configuration")
@Component
public class ImportResource {

    // Qualifier Annotation

//    @Component("fooFormatter")
//    public class FooFormatter implements Formatter {
//        public String format() {} }
//    @Component("barFormatter")
//    @Primary() defines a preference when multiple beans of the same type are present
//    public class BarFormatter implements Formatter {
//        public String format() {} }
//
//    @Component
//    public class FooService {
//        @Qualifier("fooFormatter") It will tell which bean to be injected, we can avoid ambiguity when Spring finds multiple beans of the same type.
//        @Autowired ,  It will throw an error saying  NoUniqueBeanDefinitionException. This is because Spring doesn't know which bean to inject
//        private Formatter formatter;
//    }
//  If primary and qualifier both are present then qualifier will have precedence


}
