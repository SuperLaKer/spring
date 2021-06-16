package aa.spring.task.b_taskScheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class TaskExamples {

	@Scheduled(cron = "*/1 * * * * *")
	public void sayHi_0() {
		System.out.println("hi_0");
	}

	@Scheduled(cron = "*/3 * * * * *")
	public void sayHi_1() {
		System.out.println("hi_1");
	}

	@Scheduled(cron = "@hourly")
	public void sayHi_2() {
		System.out.println("hi_2");
	}

}
