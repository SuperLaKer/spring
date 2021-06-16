package aa.spring.analysis.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lla, 2021/2/10  13:47
 */
@Component
public class DemoBean1 {

	@Autowired
	DemoBean2 demoBean2;

	public void sayHi1() {
		System.out.println("ScanDemoBean1 sayHi...");
	}
}
