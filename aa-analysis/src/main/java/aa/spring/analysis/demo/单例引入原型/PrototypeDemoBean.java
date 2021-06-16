package aa.spring.analysis.demo.单例引入原型;

import org.springframework.context.annotation.Scope;

/**
 * @author lla, 2021/2/15  14:11
 */
@Scope("prototype")
public class PrototypeDemoBean {
	public void printHashCode() {
		System.out.println(this.hashCode());
	}
}
