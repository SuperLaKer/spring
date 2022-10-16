package org.springframework.aop.inject;

import org.springframework.aop.beans.MainBean;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Method;

public class Inject05MainEL {
	public static void main(String[] args) throws NoSuchMethodException {
		GenericApplicationContext context = new GenericApplicationContext();
		ContextAnnotationAutowireCandidateResolver candidateResolver = new ContextAnnotationAutowireCandidateResolver();
		candidateResolver.setBeanFactory(context);
		Method setEnv = MainBean.class.getDeclaredMethod("setEnv", String.class);
		MethodParameter methodParameter = new MethodParameter(setEnv, 0);
		DependencyDescriptor descriptor = new DependencyDescriptor(methodParameter, false);
		// 获取@Value的value
		Object value = candidateResolver.getSuggestedValue(descriptor);
		System.out.println("\033[32;1;1m******" + value + "******\033[0m");
		assert value != null;
		System.out.println(value.getClass());
		// 解析${}。解析EL表达式。$Value("#{@beanName.properties}") -> SpringEL
		value = context.getEnvironment().resolvePlaceholders(value.toString());
		String value2 = context.getEnvironment().resolvePlaceholders("${JAVA_HOME}");
		// 类型转换
		TypeConverter typeConverter = context.getBeanFactory().getTypeConverter();
		value = typeConverter.convertIfNecessary(value, descriptor.getDependencyType());
		assert value != null;
		System.out.println(value.getClass());
		System.out.println(value);
		System.out.println(value2);
	}
}
