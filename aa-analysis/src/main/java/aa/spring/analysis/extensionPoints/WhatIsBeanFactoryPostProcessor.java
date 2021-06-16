package aa.spring.analysis.extensionPoints;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author lla, 2021/2/10  1:38
 * <p>
 * 可以修改beanDefinition
 */
public class WhatIsBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("");
		beanDefinition.setBeanClassName("");


		beanFactory.getBean("");
		// 等等
	}
}
