package aa.spring.analysis.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lla, 2021/2/10  13:47
 */
@Component
public class DemoBean2 {

	@Autowired
	DemoBean1 demoBean1;

	public void sayHi2() {
		System.out.println("ScanDemoBean2 sayHi...");
	}
}
