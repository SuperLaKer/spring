package aa.env.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Application.class);
		ac.refresh();

		// cglib代理类
		Application application = ac.getBean(Application.class);
		System.out.println(application);
		for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		ac.close();
	}
}
