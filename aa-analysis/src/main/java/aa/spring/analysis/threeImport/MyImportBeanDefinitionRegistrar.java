package aa.spring.analysis.threeImport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lla, 2021/2/10  11:17
 * <p>
 * 使用register()和scan()注册beanDefinition无法插手构建bd的过程
 * BeanDefinitionPostProcessor和ImportBeanDefinitionRegistrar都能插手BeanDefinition的建设
 * 参与bd的建设：@MapperScan的原理
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

	}
}
