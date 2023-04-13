package Base.LandingPage.Scheduler;

import Base.Funtionalities.AllStuffRelatedToArraysAndItsTypes;
import Base.LandingPage.Enums.StatesEnumMapping;
import Base.LandingPage.Model.AllDifferentInputParamters;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Timestamp;
import java.util.List;

@Configuration
@EnableScheduling
public class Scheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);


    @Scheduled(cron= "${schedulerTime}" )
    public void scheduler() {
        AllDifferentInputParamters reqObject = new AllDifferentInputParamters();
        AllDifferentInputParamters clonedObject = SerializationUtils.clone(reqObject); // We need to add the code in all the classes and the code for the clone()
        LOGGER.info("Scheduler is Running : "  + new Timestamp(System.currentTimeMillis()));

        List<String> stateEnumState = StatesEnumMapping.getStateEnumNames();

        List<String> stateNames = StatesEnumMapping.getStateNames();

        StatesEnumMapping enumObject = StatesEnumMapping.getStateEnum(StatesEnumMapping.HR);

        AllStuffRelatedToArraysAndItsTypes.newArrayTypes();

    }

}
