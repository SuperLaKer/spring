package aa.spring.analysis.demo.接口实例化;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lla, 2021/2/10  12:57
 * <p>
 * 一个demo，为接口创建对象并且注册到spring容器中
 * <p>
 * 需要借助spring的扫描方法获取权限定类名
 * 借助factoryBean和ImportBeanDefinitionRegistrar方法
 */
public class TheFactoryBean<T> implements FactoryBean<T>, InvocationHandler {

	Class<T> clazz;

	public TheFactoryBean(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getObject() throws Exception {
		return (T) Proxy.newProxyInstance(TheFactoryBean.class.getClassLoader(), new Class[]{clazz}, this);
	}

	@Override
	public Class<T> getObjectType() {
		return clazz;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * @param proxy  代理对象
	 * @param method 被拦截的方法
	 * @param args   参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Class<?>[] classes = null;
		if (args != null) {
			classes = new Class<?>[args.length];
			int i = 0;
			for (Object arg : args) {
				classes[i] = arg.getClass();
				i++;
			}
		}
		Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), classes);
		MySelect declaredAnnotation = method1.getDeclaredAnnotation(MySelect.class);
		System.out.println(declaredAnnotation.value());
		System.out.println("demoFactoryBean: " + clazz.getSimpleName());
		return null;
	}
}
