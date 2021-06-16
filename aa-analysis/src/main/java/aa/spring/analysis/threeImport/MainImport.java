package aa.spring.analysis.threeImport;

import org.springframework.context.annotation.Import;

/**
 * @author lla, 2021/2/10  11:14
 * <p>
 * Import注解 可以导入三种类
 * 1、普通的类
 * 2、实现了ImportSelector接口的类
 * 3、实现了ImportBeanDefinitionRegistrar接口的类
 */
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
public class MainImport {

}
