package Base.LandingPage.Scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Timestamp;

@Configuration
@EnableScheduling
public class Scheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron= "${schedulerTime}" )
    public void scheduler() {
        LOGGER.info("Scheduler is Running : "  + new Timestamp(System.currentTimeMillis()));
    }

}
