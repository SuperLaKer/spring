package aa.spring.analysis.AOP面向切面编程;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lla, 2021/2/15  16:46
 * <p>
 * JDK动态代理基于接口实现。代理对象继承Proxy所以只能实现被代理类的接口
 * 代理对象 extends Proxy implements UserDao;
 */
@EnableAspectJAutoProxy
public class AOPMain {

}
