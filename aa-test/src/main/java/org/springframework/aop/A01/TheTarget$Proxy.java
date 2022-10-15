package org.springframework.aop.A01;

import org.springframework.aop.TheInterface;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TheTarget$Proxy implements TheInterface {

	static Method sayHi;
	static Method sayHi2;
	static Method sayHi3;
	static Map<String, Class<?>[]> methodAndParameters = new HashMap<>();

	static {
		Class<TheInterface> interfaceClass = TheInterface.class;
		Method[] methods = interfaceClass.getDeclaredMethods();
		for (Method method : methods) {
			String name = method.getName();
			methodAndParameters.put(name, method.getParameterTypes());
		}

		try {
			sayHi = interfaceClass.getDeclaredMethod("sayHi", methodAndParameters.get("sayHi"));
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		try {
			sayHi2 = interfaceClass.getDeclaredMethod("sayHi2", methodAndParameters.get("sayHi2"));
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		try {
			sayHi3 = interfaceClass.getDeclaredMethod("sayHi3", methodAndParameters.get("sayHi3"));
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	TheInvocationHandler h;

	public TheTarget$Proxy(TheInvocationHandler h) {
		this.h = h;
	}

	@Override
	public int sayHi(int a) {
		return (int) h.invoke(this, sayHi, a);
	}

	@Override
	public int sayHi2(int a) {
		return (int) h.invoke(this, sayHi2, a);
	}

	@Override
	public int sayHi3(int a) {
		return (int) h.invoke(this, sayHi3, a);
	}
}
