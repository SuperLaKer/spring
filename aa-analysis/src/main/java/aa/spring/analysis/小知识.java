package aa.spring.analysis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * @author lla, 2021/2/15  15:27
 * <p>
 * 注入问题: 一个接口两个实现，其中一个实现可以添加@Primary或者使用 @Qualifier("实现类名字")
 * 注入不同的数据源
 */
@DependsOn()  // 此bean的实例化依赖其他bean
@Lazy(value = false)  // true: 不会实例化（构造不会执行），在getBean的时候才会开始构对象
@ComponentScan(basePackages = "org.example",
		includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository"),
		excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class)})
@SuppressWarnings("all")
public class 小知识 {

	public static void main(String[] args) {

	}
}
