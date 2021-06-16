package aa.spring.analysis.demo.环境.beans;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author lla, 2021/2/14  17:19
 */
public class EnvDemoBean1 implements EnvironmentAware {

	private Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public void sayHi() {
		System.out.println("EnvDemoBean1...");
	}
}
