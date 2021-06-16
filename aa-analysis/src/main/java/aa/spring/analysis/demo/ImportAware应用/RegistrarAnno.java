package aa.spring.analysis.demo.ImportAware应用;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lla, 2021/2/13  14:06
 */
// 导入Registrar
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyBeanDefinitionRegistrar.class)
public @interface RegistrarAnno {
	String userName() default "root";

	String password() default "roottt";

	String dataBaseName() default "sfnotes";

	String url() default "jdbc:mysql://localhost:3306/databasename?useSSL=false&serverTimezone=UTC";
}
