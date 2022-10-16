package org.springframework.aop.inject;

import org.springframework.aop.beans.Bean2;
import org.springframework.aop.beans.MainBean;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * beanDefinition -> 半成品（反射创建） -> 依赖注入beanPostProcessor.postProcessProperties
 */
public class InjectProcessor {
	public static void main(String[] args) {
		GenericApplicationContext ac = new GenericApplicationContext();
		// 注解扫描注册beanDefinition
		ac.registerBean(ConfigurationClassPostProcessor.class);
		// 解析Resource, @PostConstruct, @PreDestroy
		ac.registerBean(CommonAnnotationBeanPostProcessor.class);
		// @Autowired, @Value
		ac.registerBean(AutowiredAnnotationBeanPostProcessor.class);
		// 解析@Value的value
		ContextAnnotationAutowireCandidateResolver resolver;
		resolver = new ContextAnnotationAutowireCandidateResolver();
		ac.getDefaultListableBeanFactory().setAutowireCandidateResolver(resolver);

		ac.registerBean("mainBean", MainBean.class);
		ac.registerBean("bean2", Bean2.class);
		ac.refresh();
		ac.close();
	}
}
