package aa.webmvc.argsResolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author slk
 */
public class SetIdArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		SetUserId pathVariable = parameter.getParameterAnnotation(SetUserId.class);
		return (pathVariable != null);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer
			, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String sessionId = webRequest.getSessionId();
		// redis获取
		// 获取id
		return 1;
	}
}
