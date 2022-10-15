package org.springframework.aop.A01;

import org.springframework.aop.TheTarget;

public class TheMain {
	public static void main(String[] args) {
		TheTarget theTarget = new TheTarget();
		TheTarget$Proxy theTarget$Proxy = new TheTarget$Proxy(new TheInvocation(theTarget));
		System.out.println(theTarget$Proxy.sayHi(1));
	}
}
