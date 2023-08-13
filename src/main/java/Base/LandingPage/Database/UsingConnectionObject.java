package Base.LandingPage.Database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class UsingConnectionObject {

    @Bean(name = "connectionObject") // If we want to give name to the bean object
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-EJP9PDOR;databaseName=Spring;encrypt=true;trustServerCertificate=true;", "badmash", "badmash");
        return connection;
    }

}
