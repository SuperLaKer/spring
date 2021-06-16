package aa.spring.analysis.环境和Profile;

import org.springframework.context.annotation.Profile;

/**
 * @author lla, 2021/2/15  15:57
 */
@Profile("pro")
public class ProfileDemoPro implements ProfileDemo {

	@Override
	public void sayHi() {
		System.out.println(this.getClass().getSimpleName() + "hi...");
	}

}
