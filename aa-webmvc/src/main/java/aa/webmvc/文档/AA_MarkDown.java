package aa.webmvc.文档;


/**
 * 三大组件初始化顺序：listener > filter > servlet
 * ContextLoaderListener  配置文件 DispatcherServlet
 * <p>
 * <p>
 * <p>
 * <p>
 * 1、使用Java的方式配置web环境(容器、dispatcherServlet、视图解析器)
 * 2、配置类：@Configuration @EnableWebMvc
 * 3、视图解析器：把字符串转化为xx.html，视图解析器在 """配置类中设置"""
 * <p>
 * <p>
 * <p>
 * controller三种类型: RequestMappingHandlerMapping, BeanNameUrlHandlerMapping, RouterFunctionMapping
 * HandlerExecutionChain handler = mapping.getHandler(request);最后选出来一个handler
 * <p>
 * 一个URL对应一个类             handlerMapping映射 url 和类   BeanNameUrlHandlerMapping
 * 一个URL对应一个方法            handlerMapping映射 url 和 method  RequestMappingHandlerMapping
 * 还有一个是啥？忘了
 * chain = new HandlerExecutionChain(HandlerMethod)
 * return chain.iterAddInterceptor(interceptor)
 */
public class AA_MarkDown {
}
