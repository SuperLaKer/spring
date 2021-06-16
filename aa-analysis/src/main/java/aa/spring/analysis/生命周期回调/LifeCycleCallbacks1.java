package aa.spring.analysis.生命周期回调;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;

/**
 * @author lla, 2021/2/15  15:02
 * 基于继承, 销毁方法需要原型
 */
@Scope("prototype")
public class LifeCycleCallbacks1 implements InitializingBean, DisposableBean {

	public void sayHi() {
		System.out.println("hi ...");
	}

	public LifeCycleCallbacks1() {
		// 肯定是在构造方法之后，构造方法生命周期的开始
		System.out.println("Constructor ...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 属性设置完成，相当于init方法
		System.out.println("init ...");
	}

	@Override
	public void destroy() throws Exception {
		// 销毁之前，用来释放资源
		System.out.println("destroy ...");
	}
}
