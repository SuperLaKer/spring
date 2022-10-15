package org.springframework.aop.inject;

import org.springframework.aop.beans.MainBean;
import org.springframework.aop.beans.Bean2;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.StandardEnvironment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 半成品injectBean1的依赖注入
 */
public class Inject02Main {
	public static void main(String[] args) throws Throwable {

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerSingleton("injectBean2", new Bean2());  // 成熟
		// beanFactory.registerSingleton("injectBean1", new InjectBean1());

		// 获取@Value里面的内容也就是${}
		ContextAnnotationAutowireCandidateResolver candidateResolver = new ContextAnnotationAutowireCandidateResolver();
		beanFactory.setAutowireCandidateResolver(candidateResolver);
		// 解析${}
		beanFactory.addEmbeddedValueResolver(new StandardEnvironment()::resolvePlaceholders);
		// @Autowired, @Value注入
		AutowiredAnnotationBeanPostProcessor autowiredPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredPostProcessor.setBeanFactory(beanFactory);
		MainBean mainBean = new MainBean();  // 半成品
		// 和分步注入冲突
		// 成品（注入完成）
		// autowiredPostProcessor.postProcessProperties(null, injectBean1, "injectBean1");

		// 分步注入。先统计某个类需要注入的数据(injectionMetadata)，在执行注入
		// 成品（注入完成）
		Method findAutowiringMetadata = AutowiredAnnotationBeanPostProcessor.class.getDeclaredMethod("findAutowiringMetadata", String.class, Class.class, PropertyValues.class);
		findAutowiringMetadata.setAccessible(true);
		InjectionMetadata injectionMetadata = (InjectionMetadata) findAutowiringMetadata
				.invoke(autowiredPostProcessor, "injectBean1", MainBean.class, null);
		injectionMetadata.inject(mainBean, "injectBean1", null);
		System.out.println(mainBean);


		// public InjectBean2 injectBean2;
		// 通过属性的类型(InjectBean2)去容器中查找bean
		Field injectBean2 = MainBean.class.getField("bean2");
		DependencyDescriptor descriptor = new DependencyDescriptor(injectBean2, false);
		Object bean2 = beanFactory.doResolveDependency(descriptor, "injectBean2", null, null);
		System.out.println("在容器中找到属性同类型的bean了:" + bean2);

		// @Value("${JAVA_HOME}")
		// 这个是从环境变量中找的
		Method setEnv = MainBean.class.getDeclaredMethod("setEnv", String.class);
		MethodParameter methodParameter = new MethodParameter(setEnv, 0);
		DependencyDescriptor dependencyDescriptor = new DependencyDescriptor(methodParameter, false);
		Object o = beanFactory.doResolveDependency(dependencyDescriptor, "", null, null);
		System.out.println(o);
	}
}
