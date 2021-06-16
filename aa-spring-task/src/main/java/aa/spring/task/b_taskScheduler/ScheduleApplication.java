package aa.spring.task.b_taskScheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling

@Configuration
public class ScheduleApplication {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ScheduleApplication.class, SchedulingConfig.class, TaskExamples.class);
		ac.refresh();

		Thread.sleep(10000);
		ac.close();
	}
}
