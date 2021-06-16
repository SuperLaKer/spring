package aa.spring.analysis.extensionPoints;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lla, 2021/2/10  1:02
 * <p>
 * 插手bean的实例化过程，减轻beanFactory的负担
 * 几个比较重要的
 * 1、ApplicationContextAwareProcessor
 * 2、InitDestroyAnnotationBeanPostProcessor
 * 3、InstantiationAwareBeanPostProcessor
 * 4、CommonAnnotationBeanPostProcessor
 * 5、AutowiredAnnotationBeanPostProcessor
 * 6、RequiredAnnotationBeanPostProcessor（过期了）
 * 7、BeanValidationPostProcessor
 * 8、AbstractAutoProxyCreator
 */
public class WhatIsBeanPostProcessor implements BeanPostProcessor {


	/**
	 * todo 校验是否抛异常
	 * 初始化之前执行，必须把bean返回出去，否则getBean就是null了（可能抛异常）
	 *
	 * @param bean     可以把这个bean改成代理对象返回出去，这样getBean()拿到的就是代理对象了
	 * @param beanName x
	 * @return x
	 * @throws BeansException x
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("")) {
			// 做事
		}
		return bean;
	}

	/**
	 * 初始化之后执行
	 *
	 * @param bean     x
	 * @param beanName x
	 * @return x
	 * @throws BeansException x
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
