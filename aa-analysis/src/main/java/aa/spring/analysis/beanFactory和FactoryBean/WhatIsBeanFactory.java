package aa.spring.analysis.beanFactory和FactoryBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lla, 2021/2/10  0:11
 */
public class WhatIsBeanFactory {
	public static void main(String[] args) {
		/*
		 * BeanFactory是一个工厂
		 * 提供获取bean相关信息的api
		 * 无法注册bean
		 * */
		BeanFactory beanFactory = new AnnotationConfigApplicationContext();
	}
}
