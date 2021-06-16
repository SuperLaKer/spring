package aa.webmvc.argsResolver;

import java.lang.annotation.*;

/**
 * @author slk
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SetUserId {
	boolean required() default true;
}
