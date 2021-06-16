package aa.spring.analysis.demo.接口实例化.interfaces;

import aa.slktop.commons.domain.Users;
import aa.slktop.spring.demo.接口实例化.MySelect;

import java.util.List;

/**
 * @author lla, 2021/2/10  12:58
 */
public interface DemoRolesMapper {
	@MySelect("roles select...")
	List<Users> selectList();
}
