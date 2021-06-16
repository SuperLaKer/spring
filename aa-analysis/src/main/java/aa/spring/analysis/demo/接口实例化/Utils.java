package aa.spring.analysis.demo.接口实例化;

import org.springframework.util.Assert;
import aa.slktop.spring.如何扫描的.FullClassMain;

import java.io.File;
import java.util.ArrayList;

/**
 * @author lla, 2021/2/10  14:52
 */
public class Utils {

	// 获取包里面所有的clazz
	public static ArrayList<Class<?>> getClazz(String basePackage) {
		String rootPath = FullClassMain.class.getResource("/").getPath();
		String basePackagePath = basePackage.replaceAll("\\.", "\\\\");
		File file = new File(rootPath + "//" + basePackagePath);
		String[] names = file.list();
		Assert.notNull(names, "没有文件...");
		ArrayList<Class<?>> clazzList = new ArrayList<>();
		for (String name : names) {
			name = name.replaceAll(".class", "");
			try {
				Class<?> clazz = Class.forName(basePackage + "." + name);
				clazzList.add(clazz);
				// clazz.isAnnotationPresent(SLKAnnotation.class) 注解是否存在
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clazzList;
	}
}
