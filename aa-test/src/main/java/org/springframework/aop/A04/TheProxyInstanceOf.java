package org.springframework.aop.A04;

import org.springframework.aop.A03.CreateAdvisor;
import org.springframework.aop.TheInterface;
import org.springframework.aop.TheTarget;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Proxy;

public class TheProxyInstanceOf {
	public static void main(String[] args) throws Exception {
		// 切面
		DefaultPointcutAdvisor advisor = CreateAdvisor.creatAdvisor();
		// 创建代理对象
		TheTarget target = new TheTarget();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);  // 目标对象
		proxyFactory.addAdvisor(advisor); //  切面
		proxyFactory.setInterfaces(target.getClass().getInterfaces());  // 目标对象的接口（JDK动态代理，不设置使用cglib）
		TheInterface targetProxy = (TheInterface) proxyFactory.getProxy();

		if (targetProxy instanceof Proxy) {
			Proxy proxy = (Proxy) targetProxy;
			Class<? extends Proxy> proxyClass = proxy.getClass();
			System.out.println("proxy: " + proxyClass);
		}

		if (targetProxy instanceof Advised) {
			Advised advised = (Advised) targetProxy;
			TheTarget theTarget = (TheTarget) advised.getTargetSource().getTarget();
			assert theTarget != null;
			System.out.println(theTarget.sayHi(11));
		}

		for (int i = 0; i < 10; i++) {
			System.in.read();
			targetProxy.sayHi(11);
		}
	}
}

// stack com.sun.proxy.$Proxy0 sayHi
