package aa.spring.analysis.demo.屬性填充完成.beans;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author lla, 2021/2/10  13:47
 */
public class InitDemoBean1 implements InitializingBean {

	public InitDemoBean2 initDemoBean2;

	public void sayHi() {
		initDemoBean2.sayHi();
	}

	/**
	 * 属性注入完成调用此方法
	 *
	 * @throws Exception x
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initDemoBean1完成属性注入...");
	}

	public void setInitDemoBean2(InitDemoBean2 initDemoBean2) {
		this.initDemoBean2 = initDemoBean2;
	}

	public InitDemoBean2 getInitDemoBean2() {
		return initDemoBean2;
	}
}
