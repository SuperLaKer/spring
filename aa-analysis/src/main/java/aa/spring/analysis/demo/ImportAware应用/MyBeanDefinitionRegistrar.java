package aa.spring.analysis.demo.ImportAware应用;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author lla, 2021/2/13  13:48
 */
public class MyBeanDefinitionRegistrar implements ImportAware {
	String userName = null;
	String password = null;
	String dataBaseName = null;
	String url = null;

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		// 获取某个配套注解
		AnnotationAttributes registrar配套注解Attrs = AnnotationAttributes
				.fromMap(importMetadata.getAnnotationAttributes(RegistrarAnno.class.getName()));
		if (registrar配套注解Attrs == null) throw new RuntimeException("可能没有导入此registrar");

		this.userName = registrar配套注解Attrs.getString("userName");
		this.password = registrar配套注解Attrs.getString("password");
		this.dataBaseName = registrar配套注解Attrs.getString("dataBaseName");

		this.url = registrar配套注解Attrs.getString("url");
		this.url = this.url.replace("databasename", this.dataBaseName);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername(this.userName);
		dataSource.setPassword(this.password);
		dataSource.setUrl(this.url);
		return dataSource;
	}


}
