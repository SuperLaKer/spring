package aa.spring.analysis.demo.单例引入原型;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author lla, 2021/2/15  14:11
 */
public class SingletonDemoBean1 implements ApplicationContextAware {


	ApplicationContext applicationContext;

	public void printHashCode() {
		System.out.println("singletonBean1: " + this.hashCode());
		System.out.println("singletonBean1->prototypeBean: " + applicationContext.getBean(PrototypeDemoBean.class).hashCode());
		System.out.println("singletonBean1->prototypeBean: " + applicationContext.getBean(PrototypeDemoBean.class).hashCode());
		System.out.println("singletonBean1->prototypeBean: " + applicationContext.getBean(PrototypeDemoBean.class).hashCode());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
