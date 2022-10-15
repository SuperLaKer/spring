package org.springframework.aop.A02;

import org.springframework.aop.TheInterface;
import org.springframework.aop.TheTarget;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class JDKProxyAPI {
	public static void main(String[] args) throws IOException {
		TheTarget theTarget = new TheTarget();
		Class<? extends TheTarget> targetClass = theTarget.getClass();
		TheInterface proxyInstance = (TheInterface) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(),
				(proxy, method, args1) -> {
					System.out.println("前置通知...");
					return method.invoke(theTarget, args1);
				});
		System.out.println(proxyInstance.sayHi(1));
		System.out.println(proxyInstance.getClass().getName());
		System.in.read();
	}
}
