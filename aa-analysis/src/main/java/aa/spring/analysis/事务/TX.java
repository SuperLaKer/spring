package aa.spring.analysis.事务;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import slk.slkEnv.annno.EnableSpringDataSource;
import aa.slktop.spring.事务.我的Connect.ConnectAspect;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lla, 2021/2/17  13:24
 */
@EnableTransactionManagement
@EnableSpringDataSource
public class TX {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ac);
		scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
		ac.register(TX.class, ConnectAspect.class);
		scanner.scan("slk.slkTop.springAPI.tx.demoBean", "slk.slkTop.commons.beans");
		ac.refresh();
		for (String beanDefinitionName : ac.getBeanDefinitionNames()) {
			System.out.println(beanDefinitionName);
		}
		DataSource dataSource = ac.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
}
