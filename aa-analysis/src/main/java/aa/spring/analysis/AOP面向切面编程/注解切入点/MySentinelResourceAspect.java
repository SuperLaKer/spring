package aa.spring.analysis.AOP面向切面编程.注解切入点;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MySentinelResourceAspect {
	@Pointcut("@annotation(aa.slktop.spring.AOP面向切面编程.注解切入点.MySentinelResource)")
	public void sentinelResourceAnnotationPointcut() {
	}

	@Around("sentinelResourceAnnotationPointcut()")
	public Object invokeResourceWithSentinel(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println(pjp);
		return null;

		// MySentinelResource annotation = originMethod.getAnnotation(MySentinelResource.class);
	}
}
