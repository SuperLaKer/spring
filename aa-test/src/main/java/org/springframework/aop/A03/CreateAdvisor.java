package org.springframework.aop.A03;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.TheInterface;
import org.springframework.aop.TheTarget;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.io.IOException;

/**
 * 使用底层切面创建代理对象，并使用arthas查看内存中代理对象的源码
 */
public class CreateAdvisor {

	/**
	 * 创建切面
	 */
	public static DefaultPointcutAdvisor creatAdvisor() throws NoSuchMethodException {
		// === 准备切点表达式（这里使用aspect表达式、也可以使用基于注解的 AnnotationMatchingPointcut）
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution( * org.springframework.aop.TheTarget.sayHi(..))");
		// 使用表达式，是否支持给某个方法做增强
		MethodMatcher methodMatcher = pointcut.getMethodMatcher();
		Class<TheTarget> targetClass = TheTarget.class;
		boolean isSupport = methodMatcher
				.matches(targetClass.getDeclaredMethod("sayHi", int.class), targetClass);
		System.out.println("该切面是否支持这个方法: " + isSupport);

		// === 准备通知
		MethodInterceptor interceptor = (methodInvocation) -> {
			System.out.println("before...");
			Object proceed = methodInvocation.proceed();
			System.out.println("after...");
			return proceed;
		};
		// === 创建切面类
		return new DefaultPointcutAdvisor(pointcut, interceptor);
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) throws NoSuchMethodException, IOException {
		// 切面
		DefaultPointcutAdvisor advisor = creatAdvisor();
		// 创建代理对象
		TheTarget target = new TheTarget();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);  // 目标对象
		proxyFactory.addAdvisor(advisor); //  切面
		proxyFactory.setInterfaces(target.getClass().getInterfaces());  // 目标对象的接口（JDK动态代理，不设置使用cglib）
		TheInterface targetProxy = (TheInterface) proxyFactory.getProxy();

		System.out.println(targetProxy.getClass());
		targetProxy.sayHi(1);  // 增强
		targetProxy.sayHi2(1);  // 增强
		targetProxy.sayHi3(1);  // 没有被增强
		System.in.read();
	}
}
