package aa.spring.analysis.demo.接口实例化;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @author lla, 2021/2/10  13:07
 */
public class TheBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		ArrayList<Class<?>> interfacesClasses = Utils.getClazz("slk.slkTop.springAPI.demo.接口实例化.interfaces");
		for (Class<?> interfaceClass : interfacesClasses) {

			/*为接口创建beanDefinition*/
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(interfaceClass);
			AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
			/*接口不能实例化, 需要借助FactoryBean*/
			beanDefinition.setBeanClass(TheFactoryBean.class);
			/*直接给构造方法赋值*/
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(interfaceClass.getName());

			// A 65 ; a 97
			String simpleName = interfaceClass.getSimpleName();
			char c = simpleName.charAt(0);
			String s = String.valueOf(c);
			String newString = simpleName.replaceFirst(s, s.toLowerCase(Locale.ROOT));
			registry.registerBeanDefinition(newString, beanDefinition);
		}
	}
}
