package aa.spring.analysis.环境和Profile;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lla, 2021/2/15  15:59
 */
public class UseProfile {

	// 这样肯定会异常的
	@Autowired
	ProfileDemo profileDemo;

	public void sayHi() {
		profileDemo.sayHi();
	}

}
