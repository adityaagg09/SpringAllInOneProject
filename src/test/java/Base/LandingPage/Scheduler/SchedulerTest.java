package Base.LandingPage.Scheduler;

import Base.LandingPage.Enums.StatesEnumMapping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchedulerTest {

    @InjectMocks
    Scheduler scheduler;

    @Test
    public void test_schedulerCompleteData() throws InterruptedException {
        scheduler.scheduler();
    }

}
