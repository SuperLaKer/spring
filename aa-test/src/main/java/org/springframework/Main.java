package org.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Main.class);
		ac.refresh();
		try {
			// 输出：org.springframework.context.annotation.internalConfigurationAnnotationProcessor
			System.out.println(ac.getBeanDefinitionNames()[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ac.close();
		}
	}
}