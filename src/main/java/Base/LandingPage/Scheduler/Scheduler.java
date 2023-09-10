package Base.LandingPage.Scheduler;

import Base.Funtionalities.AllStuffRelatedToArraysAndItsTypes;
import Base.Funtionalities.Streams_Filters;
import Base.LandingPage.Database.QueryDbUsingJdbcTemplate;
import Base.LandingPage.Database.PerformQueryUsingConnection;
import Base.LandingPage.Doa.CallingDB;
import Base.LandingPage.Enums.StatesEnumMapping;
import Base.LandingPage.Model.AllDifferentInputParamters;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Configuration
@EnableScheduling
public class Scheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    // It helps in faster read as variables are now final, less memory, Auto garbage collector
    // It will initialize as constructor is called because they are final, else in other gets initialized only when we use them for concurrent
    @Autowired
    public Scheduler(CallingDB callingDB, QueryDbUsingJdbcTemplate queryDbUsingJdbcTemplate, PerformQueryUsingConnection performQueryUsingConnection) {
        this.callingDB = callingDB;
        this.queryDbUsingJdbcTemplate = queryDbUsingJdbcTemplate;
        this.performQueryUsingConnection = performQueryUsingConnection;
    }

//    @Autowired
    private final CallingDB callingDB;

//    @Autowired
    private final QueryDbUsingJdbcTemplate queryDbUsingJdbcTemplate;

//    @Autowired
    private final PerformQueryUsingConnection performQueryUsingConnection;


    @Scheduled(cron= "${schedulerTime}" )
    public void scheduler() throws InterruptedException, SQLException {
        AllDifferentInputParamters reqObject = new AllDifferentInputParamters();
        AllDifferentInputParamters clonedObject = SerializationUtils.clone(reqObject); // We need to add the code in all the classes and the code for the clone()
        LOGGER.info("Scheduler is Running : "  + new Timestamp(System.currentTimeMillis()));

        LOGGER.info(callingDB.test());

        queryDbUsingJdbcTemplate.insertRecords();

        queryDbUsingJdbcTemplate.queryRecords();

        performQueryUsingConnection.insertIntoDb();



        List<String> stateEnumState = StatesEnumMapping.getStateEnumNames();

        List<String> stateNames = StatesEnumMapping.getStateNames();

        StatesEnumMapping enumObject = StatesEnumMapping.getStateEnum(StatesEnumMapping.HR);

        AllStuffRelatedToArraysAndItsTypes.newArrayTypes();

        Streams_Filters.Filters();

        Streams_Filters.Map();

    }

}