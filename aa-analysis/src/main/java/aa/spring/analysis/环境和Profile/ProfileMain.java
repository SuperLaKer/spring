package aa.spring.analysis.环境和Profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lla, 2021/2/15  16:00
 */
public class ProfileMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		// 先设置环境，再扫描
		ac.getEnvironment().setActiveProfiles("dev");
		ac.register(ProfileDemoDev.class, ProfileDemoPro.class, UseProfile.class);
		// 环境不一样不会加载
		ac.refresh();
		UseProfile useProfile = ac.getBean(UseProfile.class);
		useProfile.sayHi();
	}
}
