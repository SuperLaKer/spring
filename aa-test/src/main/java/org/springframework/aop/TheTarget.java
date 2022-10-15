package org.springframework.aop;

import org.springframework.ShouldProxy;

public class TheTarget implements TheInterface {

	@ShouldProxy("123")
	public int sayHi(int a) {
		System.out.println(TheTarget.class.getSimpleName() + "...");
		return a;
	}

	@ShouldProxy("123")
	public int sayHi2(int a) {
		System.out.println(TheTarget.class.getSimpleName() + "...");
		return a;
	}

	@ShouldProxy("123")
	public int sayHi3(int a) {
		sayHi(a);
		return a;
	}
}
