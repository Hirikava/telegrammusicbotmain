package Common;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import Common.Messenger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Planner {

  public static void task() {
    try {
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

      // and start it off
      // define the job and tie it to our HelloJob class
      JobDetail job = newJob(Messenger.class)
          .withIdentity("job1", "group1")
          .build();
      Trigger trigger = newTrigger()
          .withIdentity("trigger1", "group1")
          .startNow()
          .withSchedule(simpleSchedule()
              .withIntervalInSeconds(4)
              .repeatForever())
          .build();

      // Tell quartz to schedule the job using our trigger
      scheduler.scheduleJob(job, trigger);
      scheduler.start();

    } catch (SchedulerException se) {
      se.printStackTrace();
    }
  }
}