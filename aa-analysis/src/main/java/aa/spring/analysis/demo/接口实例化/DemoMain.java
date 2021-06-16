package aa.spring.analysis.demo.接口实例化;

import aa.slktop.spring.demo.接口实例化.interfaces.DemoUsersMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import aa.slktop.commons.domain.Users;

import java.util.List;

/**
 * @author lla, 2021/2/10  13:18
 */
@Configuration
@Import(TheBeanDefinitionRegistrar.class)
@ComponentScan("slk.slkTop.springapi.demo.接口实例化.interfaces")
public class DemoMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoMain.class);
		for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		// 自动注入，如果没有类型，就按照名字注入
		DemoUsersMapper demoUsersMapper = (DemoUsersMapper) applicationContext.getBean("DemoUsersMapper");
		List<Users> users = demoUsersMapper.selectList();
		DemoUsersMapper bean = applicationContext.getBean(DemoUsersMapper.class);

	}
}
