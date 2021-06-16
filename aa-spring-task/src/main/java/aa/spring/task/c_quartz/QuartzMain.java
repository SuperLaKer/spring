package aa.spring.task.c_quartz;

import org.quartz.JobDataMap;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import org.quartz.JobDetail;

@Configuration
@Import(ExampleJob.class)
public class QuartzMain {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(QuartzMain.class);
		ac.refresh();
		Thread.sleep(10000);
	}

	@Bean
	public JobDetail exampleTask() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("timeout", 5);
		jobDetailFactoryBean.setJobClass(ExampleJob.class);
		jobDetailFactoryBean.setJobDataMap(jobDataMap);
		return jobDetailFactoryBean.getObject();
	}
}
