package pokemon.batch;

import java.time.LocalDateTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TareaEnviarSugerencia implements Job {
  private final Logger log = LoggerFactory.getLogger(TareaEnviarSugerencia.class);

  public void execute(JobExecutionContext jobExecutionContext) {
    System.out.println(LocalDateTime.now());
    System.out.println("Enviando sugerencias....");
    System.out.println("Sugerencias enviadas");
  }
}

