package aa.spring.analysis.demo.环境;

import aa.slktop.spring.demo.环境.beans.EnvDemoBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lla, 2021/2/14  17:18
 */
@Configuration
@Import(EnvDemoBean1.class)
public class EnvMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(EnvMain.class);
		EnvDemoBean1 envDemoBean1 = ac.getBean(EnvDemoBean1.class);
		envDemoBean1.sayHi();
	}
}
