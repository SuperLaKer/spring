package org.springframework.aop;

import org.springframework.aop.beans.Bean2;
import org.springframework.aop.beans.MainBean;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;

public class InjectMain {
	public static void main(String[] args) {
		GenericApplicationContext ac = new GenericApplicationContext();

		ac.registerBean(ConfigurationClassPostProcessor.class);
		ac.registerBean(CommonAnnotationBeanPostProcessor.class);
		ac.registerBean(AutowiredAnnotationBeanPostProcessor.class);
		ContextAnnotationAutowireCandidateResolver resolver;
		resolver = new ContextAnnotationAutowireCandidateResolver();
		ac.getDefaultListableBeanFactory().setAutowireCandidateResolver(resolver);

		ac.registerBean("mainBean1", MainBean.class);
		ac.registerBean("bean2", Bean2.class);
		ac.refresh();

		System.out.println(ac.getBean(MainBean.class));
		Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
