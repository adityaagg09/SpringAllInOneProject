package Base.LandingPage.Database;

import Base.LandingPage.Model.DbSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

import static Base.Funtionalities.JsonPrinter.toJson;

@Configuration
public class QueryDbUsingJdbcTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryDbUsingJdbcTemplate.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void test() {
        int rows = jdbcTemplate.update("INSERT INTO personalData (Name) values('yayy!!!!!!!!')");
        System.out.println(rows);
    }

    public void insertRecords() {
        String query = "insert into personalData values( :name , :adress, :age)";
        DbSchema dbSchema = getDbSchemaObject();
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", dbSchema.getName())
                .addValue("adress", dbSchema.getAdress())
                .addValue("age", dbSchema.getAge());
        int rows = jdbcTemplate.update(query, parameterSource);
        if(rows > 0 ) LOGGER.info("insertRecords(): Records updated successfully for object: {}", dbSchema.toString());
        else LOGGER.info("Error while updating records");
    }

    public void queryRecords() {
        String query  = "select * from personalData";
        List<DbSchema> result = jdbcTemplate.query(query, new BeanPropertyRowMapper(DbSchema.class));
        LOGGER.info("queryRecords(): Result received is : {}", toJson(result));
    }


    public DbSchema getDbSchemaObject() {
        DbSchema dbSchema = new DbSchema();
        dbSchema.setAdress("AmbalaHarayana");
        dbSchema.setAge(12);
        dbSchema.setName("Aditya");
        return  dbSchema;
    }

}
