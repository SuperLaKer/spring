package org.springframework.aop.A02;


import org.springframework.aop.TheInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements TheInterface {
	private static Method m5;
	private static Method m3;
	private static Method m4;

	static {
		try {
			m5 = Class.forName("org.springframework.aop.TheInterface").getMethod("sayHi", Integer.TYPE);
			m3 = Class.forName("org.springframework.aop.TheInterface").getMethod("sayHi2", Integer.TYPE);
			m4 = Class.forName("org.springframework.aop.TheInterface").getMethod("sayHi3", Integer.TYPE);
		} catch (NoSuchMethodException noSuchMethodException) {
			throw new NoSuchMethodError(noSuchMethodException.getMessage());
		} catch (ClassNotFoundException classNotFoundException) {
			throw new NoClassDefFoundError(classNotFoundException.getMessage());
		}
	}

	public $Proxy0(InvocationHandler invocationHandler) {
		super(invocationHandler);
	}

	public final int sayHi(int n) {
		try {
			return (Integer) this.h.invoke(this, m5, new Object[]{n});
		} catch (Error | RuntimeException throwable) {
			throw throwable;
		} catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final int sayHi2(int n) {
		try {
			return (Integer) this.h.invoke(this, m3, new Object[]{n});
		} catch (Error | RuntimeException throwable) {
			throw throwable;
		} catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final int sayHi3(int n) {
		try {
			return (Integer) this.h.invoke(this, m4, new Object[]{n});
		} catch (Error | RuntimeException throwable) {
			throw throwable;
		} catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
	}
}
