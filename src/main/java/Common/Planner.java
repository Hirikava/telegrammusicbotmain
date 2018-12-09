package Common;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Planner {

  public static void task() {
    try {
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      JobDetail job = newJob(Messenger.class)
          .withIdentity("job1", "group1")
          .build();


      Trigger trigger = newTrigger()
          .withIdentity("trigger1", "group1")
          .startNow()
          .withSchedule(simpleSchedule()
              .withIntervalInHours(1)
              .repeatForever())
          .build();

      scheduler.scheduleJob(job, trigger);
      scheduler.start();
    } catch (SchedulerException se) {
      se.printStackTrace();
    }
  }
}