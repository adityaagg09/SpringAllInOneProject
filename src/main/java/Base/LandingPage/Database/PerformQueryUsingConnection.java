package Base.LandingPage.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class PerformQueryUsingConnection {

    @Autowired
    @Qualifier("connectionObject")
    private Connection connection;

    public void insertIntoDb() throws SQLException {
        DatabaseMetaData yo = connection.getMetaData();
        System.out.println(yo);
        String sql = "INSERT INTO personalData (Name) values('yayy!!!')";
        PreparedStatement statement = connection.prepareStatement(sql);
        int rows = statement.executeUpdate();
        System.out.println(rows);
    }

    public void insertIntoDbUsingNameString(String name) throws SQLException {
        DatabaseMetaData yo = connection.getMetaData();
        System.out.println(yo);
        String sql = "INSERT INTO personalData (Name) values('yayy!!!')";
        PreparedStatement statement = connection.prepareStatement(sql);
        int rows = statement.executeUpdate();
        System.out.println(rows);
    }


}
