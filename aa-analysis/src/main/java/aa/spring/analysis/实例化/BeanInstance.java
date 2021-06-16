package aa.spring.analysis.实例化;

import aa.slktop.spring.beans.DemoBean1;
import aa.slktop.spring.beans.DemoBean2;
import aa.slktop.spring.beans.DemoBean3;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author lla, 2021/2/15  15:06
 */
public class BeanInstance {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DemoBean1.class, DemoBean2.class, DemoBean3.class);

		// 扫描器
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
		scanner.addIncludeFilter(((metadataReader, metadataReaderFactory) -> true));
		scanner.scan("aa.slktop.spring.实例化");
		// 实例化单例bean
		context.refresh();

		// 开始wrapper
		DemoBean1 bean = context.getBean(DemoBean1.class);
		bean.sayHi1();
	}
}

@EnableAspectJAutoProxy
@Aspect
@Component
@SuppressWarnings("all")
class Aspect切面 {

	/**
	 * 切入点表达式：
	 */
	@Pointcut("execution(* aa.slktop.spring.beans.DemoBean1.*(..))")
	public void thePointCut() {
	}

	;


	@Before("thePointCut()")
	public void before() {
		System.out.println("前置处理器...");
	}
}
