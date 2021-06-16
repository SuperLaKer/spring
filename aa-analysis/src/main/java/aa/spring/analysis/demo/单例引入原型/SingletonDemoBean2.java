package aa.spring.analysis.demo.单例引入原型;

import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author lla, 2021/2/15  14:11
 */
public class SingletonDemoBean2 {

	public void printHashCode() {
		System.out.println("singletonBean2: " + this.hashCode());
		System.out.println("singletonBean2->prototypeBean: " + getPrototypeDemoBean().hashCode());
		System.out.println("singletonBean2->prototypeBean: " + getPrototypeDemoBean().hashCode());
		System.out.println("singletonBean2->prototypeBean: " + getPrototypeDemoBean().hashCode());
	}

	@Lookup
	protected PrototypeDemoBean getPrototypeDemoBean() {
		return null;
	}

	;

}
