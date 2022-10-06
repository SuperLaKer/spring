package org.springframework.aa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@ComponentScan(basePackages = "org.springframework.aa")
@Import({Bean1.class, Bean2.class})
// @ImportResource(locations = "classpath:spring-beans.xml")
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Main.class, Bean1.class);
		ac.refresh();
		try {
			Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ac.close();
		}
	}
}