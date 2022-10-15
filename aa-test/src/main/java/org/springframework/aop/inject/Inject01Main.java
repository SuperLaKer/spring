package org.springframework.aop.inject;

import org.springframework.aop.beans.MainBean;
import org.springframework.aop.beans.Bean2;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 依赖注入
 */
public class Inject01Main {
	public static void main(String[] args) {
		GenericApplicationContext ac = new GenericApplicationContext();
		ac.registerBean("injectBean1", MainBean.class);
		ac.registerBean("injectBean2", Bean2.class);
		// 处理@Value中字符串对应的值
		ContextAnnotationAutowireCandidateResolver candidateResolver = new ContextAnnotationAutowireCandidateResolver();
		ac.getDefaultListableBeanFactory().setAutowireCandidateResolver(candidateResolver);
		// springboot中处理@ConfigurationProperties注解的
		// ConfigurationPropertiesBindingPostProcessor.register(ac.getDefaultListableBeanFactory());
		// @Autowired, @Value
		ac.registerBean(AutowiredAnnotationBeanPostProcessor.class);
		// @Resource, @PostConstruct, @PreDestroy
		ac.registerBean(CommonAnnotationBeanPostProcessor.class);

		ac.refresh();
		MainBean mainBean = ac.getBean(MainBean.class);
		System.out.println(mainBean);
		ac.close();
	}



}
