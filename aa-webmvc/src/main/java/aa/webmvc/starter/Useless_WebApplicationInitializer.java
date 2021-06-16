package aa.webmvc.starter;

import aa.webmvc.ApplicationConfiguration;
import aa.webmvc.filters.FilterA;
import aa.webmvc.filters.FilterB;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * tomcat容器会"""迭代"""调用此接口WebApplicationInitializer所有实现类的onStartup方法
 * 启用，使用DispatcherServletInitializer
 */
public class Useless_WebApplicationInitializer implements WebApplicationInitializer {


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	}


	public void onStartup_temp(ServletContext servletContext) {
		// register: Set<Class<?>> componentClasses  = { AppConfig.class }
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		// 先注册这个类 ---> 扫描controller + 其他配置类
		context.register(ApplicationConfiguration.class);

		/*把容器传递给了DispatcherServlet*/
		/*FrameworkServlet完成WebContext初始化*/
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        /*
            Servlet:init -> GenericServlet -> HttpServlet -> HttpServletBean
            -> FrameworkServlet -> Dispatcher(applicationContext)
         */
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");

		servletContext.addFilter("filterA", new FilterA());
		servletContext.addFilter("filterB", new FilterB());

	}

}