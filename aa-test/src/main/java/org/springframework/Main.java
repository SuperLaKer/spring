package org.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws Exception {
	    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
	    ac.register(Main.class);
	    ac.refresh();
	    try {
			// 输出：org.springframework.context.annotation.internalConfigurationAnnotationProcessor
	        System.out.println(ac.getBeanDefinitionNames()[0]);
	    }catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        TimeUnit.SECONDS.sleep(10);
	        ac.close();
	    }
	}
}