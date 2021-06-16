package aa.spring.analysis.demo.单例引入原型;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lla, 2021/2/15  14:16
 */
public class SingletonMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SingletonDemoBean1.class, SingletonDemoBean2.class, PrototypeDemoBean.class);
		context.getBean(SingletonDemoBean1.class).printHashCode();
		context.getBean(SingletonDemoBean2.class).printHashCode();

	}
}
