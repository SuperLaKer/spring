package aa.spring.analysis.AOP面向切面编程.注解切入点;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MySentinelResource {

}
