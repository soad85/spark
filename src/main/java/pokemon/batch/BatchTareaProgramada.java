package pokemon.batch;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchTareaProgramada {

  public static void main(String[] args) {
    try {
      SchedulerFactory schedulerFactory = new StdSchedulerFactory();
      JobDetail jobEnviarSugerencia = JobBuilder.newJob(TareaEnviarSugerencia.class)
          .withIdentity("jobEnviarSugerencia").build();

      Trigger triggerEnviarSugerencia = TriggerBuilder.newTrigger()
          .withSchedule(CronScheduleBuilder.cronSchedule("0/30 0/1 * 1/1 * ? *"))
          .build();

      Scheduler scheduler = schedulerFactory.getScheduler();
      scheduler.start();
      scheduler.scheduleJob(jobEnviarSugerencia, triggerEnviarSugerencia);

    } catch (SchedulerException e) {
      final Logger log = LoggerFactory.getLogger(BatchTareaProgramada.class);
      log.error("SchedulerException" + e.getMessage());
    }
  }
}
