package aa.spring.analysis.demo.ImportAware应用;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import aa.slktop.commons.beans.DemoBean1;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lla, 2021/2/13  14:19
 */
@RegistrarAnno(dataBaseName = "sfnotes")
@ComponentScan("slk.slkTop.commons.beans")
@Configuration
public class RegistrarMain {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RegistrarMain.class);
		DemoBean1 demoBean1 = (DemoBean1) applicationContext.getBean("demoBean1");
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		demoBean1.sayHi();
	}
}
