package aa.webmvc.starter;

import aa.webmvc.ApplicationConfiguration;
import aa.webmvc.filters.FilterA;
import aa.webmvc.filters.FilterB;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 创建一个WebConfigApplicationContext, 获取ConfigClass, dispatcherMapping
 */
public class SelfDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 这两个方法都是给 AnnotationConfigWebApplicationContext传递配置类
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ApplicationConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{};
	}


	@Override
	protected String[] getServletMappings() {
		return new String[]{"/*"};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{
				new HiddenHttpMethodFilter(), new CharacterEncodingFilter(),
				new FilterA(), new FilterB()
		};
	}
}