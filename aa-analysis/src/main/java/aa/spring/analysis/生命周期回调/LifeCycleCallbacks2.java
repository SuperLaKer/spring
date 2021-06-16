package aa.spring.analysis.生命周期回调;

import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lla, 2021/2/15  15:02
 * 有默认的方法
 */
@Scope("prototype")
public class LifeCycleCallbacks2 {

	public void sayHi() {
		System.out.println("hi ...");
	}

	public LifeCycleCallbacks2() {
		// 肯定是在构造方法之后，构造方法生命周期的开始
		System.out.println("Constructor ...");
	}

	/**
	 * 可以使用注解，也可以是使用XML
	 * 在XML中指定: <beans default-init-method="myInitMethod"/>, 注意是beans标签
	 */
	@PostConstruct
	public void myInitMethod() {
		System.out.println("init ...");
	}

	@PreDestroy
	public void myDestroyMethod() throws Exception {
		// 销毁之前，用来释放资源
		System.out.println("destroy ...");
	}

}
