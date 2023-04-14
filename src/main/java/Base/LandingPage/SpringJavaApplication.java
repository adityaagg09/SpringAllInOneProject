package Base.LandingPage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication()
// If we don't want to use SpringBootApplication then we can use the below 3 annotations and our application will work absolutely fine
//@Configuration
//@EnableAutoConfiguration(excludeName = "Base.Funtionalities") // It automatically creates and register beans if we don't want some packages or classes then we can remove that too
//@ComponentScan(basePackages = {"Base.LandingPage", "Base.Exception"}) // If we want to run 2 different application then we need to pass packages name here
public class SpringJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaApplication.class, args);
	}

}
