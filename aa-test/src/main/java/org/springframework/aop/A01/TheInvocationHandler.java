package org.springframework.aop.A01;

import java.lang.reflect.Method;

public interface TheInvocationHandler {
	Object invoke(Object proxy, Method method, Object... args);
}
