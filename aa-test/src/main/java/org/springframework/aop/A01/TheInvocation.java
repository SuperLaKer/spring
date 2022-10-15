package org.springframework.aop.A01;

import org.springframework.aop.TheTarget;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TheInvocation implements TheInvocationHandler {

	TheTarget target;

	public TheInvocation(TheTarget theTarget) {
		this.target = theTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object... args) {
		try {
			return method.invoke(proxy, target, args);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
