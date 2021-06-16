package aa.spring.analysis.beanFactory和FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author lla, 2021/2/10  0:22
 * <p>
 * <p>
 * mybatis的sqlSession: 需要sqlSessionFactory和configuration
 * 这两个类非常复杂，mybatis把属性填充好通过factoryBean交给spring容器维护
 * <p>
 * 让客户更加容易的使用
 */
@Component("demo1")
public class WhatIsFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		// 接口动态代理
		return new Demo1();
	}

	@Override
	public Class<?> getObjectType() {
		return Demo1.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}

class Demo1 {
	public void sayHi() {
		System.out.println("hi demo1 测试factoryBean...");
	}
}
