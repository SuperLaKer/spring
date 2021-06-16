package aa.spring.analysis.AOP面向切面编程;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lla, 2021/2/15  16:48
 */
@Aspect
@SuppressWarnings("all")
public class Aspect切面 {

	/**
	 * 切入点表达式：
	 */
	@Pointcut("")
	public void thePointCut() {
	}

	;


	@Before("thePointCut()")
	public void before() {

	}


}
