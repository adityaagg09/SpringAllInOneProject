package Base.LandingPage;


import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.apache.logging.log4j.core.appender.db.jdbc.DriverManagerConnectionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

@SpringBootApplication()
// If we don't want to use SpringBootApplication then we can use the below 3 annotations and our application will work absolutely fine
//@Configuration
//@EnableAutoConfiguration(excludeName = "Base.Funtionalities") // It automatically creates and register beans if we don't want some packages or classes then we can remove that too
//@ComponentScan(basePackages = {"Base.LandingPage", "Base.Exception"}) // If we want to run 2 different application then we need to pass packages name here
public class SpringJavaApplication  {

	// Public -> Globally available, JVm can invoke it from outside the class
	// Static -> JVM can invoke with creating an object of the class
	// void -> JVM won't do anything even if we return any other
	// main -> It is the entry point of java applications, JVM looks for main method when it start executing java programme
    // string args[] -> in java is an array of type java.lang.String class that stores java command line arguments.
	// It is imp to have same signature else it will compile but will not execute
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(SpringJavaApplication.class, args);
	}

	// Can we execute a Java program without the main method?
	// A static block in Java is a group of statements that gets executed only once when the class is loaded into the memory by ClassLoader, It is also known as a static initialization block, and it goes into the stack memory.
	// Like below
	class StaticBlock {
		static
		{
			System.out.println(
					"This class can be executed without main");
			System.exit(0);
		}
	}

	// This declaration is also valid
//	public static void main(String... args) {
//		SpringApplication.run(SpringJavaApplication.class, args);
//	}

}
