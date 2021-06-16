package aa.spring.task.a_threadPoolTaskExecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
@Import(TaskExecutorExample.class)
public class SpringApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(SpringApplication.class);
		ac.refresh();
		TaskExecutorExample taskExecutorExample = ac.getBean(TaskExecutorExample.class);
		taskExecutorExample.printMessages();

		ac.stop();
	}


	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(25);
		taskExecutor.setMaxPoolSize(25);
		taskExecutor.setQueueCapacity(25);
		return taskExecutor;
	}

}
