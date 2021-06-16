package aa.spring.analysis.如何扫描的;

import aa.slktop.spring.beans.DemoBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;


/**
 * @author lla, 2021/2/10  13:52
 */
public class FullClassMain {
	public static void main(String[] args) throws ClassNotFoundException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(FullClassMain.class, LiteClass.class);
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ac);
		scanner.addIncludeFilter(((metadataReader, metadataReaderFactory) -> true));
		scanner.scan("slk.slkTop.springAPI.beans");
		ac.refresh();

		DemoBean1 demoBean1 = ac.getBean(DemoBean1.class);
		demoBean1.sayHi1();
	}
}

class LiteClass {
	public void sayHi() {
		System.out.println("LiteClass ...");
	}
}
