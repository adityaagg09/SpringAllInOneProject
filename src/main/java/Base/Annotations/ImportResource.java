package Base.Annotations;

import org.springframework.context.annotation.Configuration;

// ImportResource used to load bean configurations from the xml file + Can be used only where @Configuration annotation is used

@Configuration
@org.springframework.context.annotation.ImportResource("classpath:location of the bean xml configuration")
public class ImportResource {
}
