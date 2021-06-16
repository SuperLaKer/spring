package aa.spring.analysis.demo.屬性填充完成;

import aa.slktop.spring.demo.屬性填充完成.beans.InitDemoBean1;
import aa.slktop.spring.demo.屬性填充完成.beans.InitDemoBean2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lla, 2021/2/14  16:54
 */
@Configuration
@Import({InitDemoBean1.class, InitDemoBean2.class})
public class InitMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(InitMain.class, ProcessBeanDefinition.class);
		InitDemoBean1 initDemoBean1 = context.getBean(InitDemoBean1.class);
		initDemoBean1.sayHi();
	}
}

/**
 * 后置处理器，获取bd，修改bd实例化是属性注入的模型
 * <p>
 * -- @Autowired: 默认AbstractBeanDefinition.AUTOWIRE_NO。先根据类型，如果找不到再根据属性名
 * -- AbstractBeanDefinition.AUTOWIRE_BY_TYPE: 使用set方法
 */
class ProcessBeanDefinition implements BeanFactoryPostProcessor {
	/*后执行*/
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		// 获取beanDefinition
		AnnotatedGenericBeanDefinition initDemoBean1BeanDefinition =
				(AnnotatedGenericBeanDefinition) beanFactory
						.getBeanDefinition("slk.slkTop.springAPI.demo.屬性填充完成.beans.InitDemoBean1");
		// 修改beanDefinition属性（自动装配模型byType使用set方法，beanClass必须为属性提供set方法）
		initDemoBean1BeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
	}
}
