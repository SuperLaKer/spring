package aa.spring.analysis.生命周期回调;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lla, 2021/2/15  15:06
 */
public class LifeCycleMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(LifeCycleCallbacks1.class, LifeCycleCallbacks2.class);
		context.refresh();
		LifeCycleCallbacks2 bean = context.getBean(LifeCycleCallbacks2.class);
		bean.sayHi();
	}
}
