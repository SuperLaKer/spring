package aa.spring.analysis.threeImport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author lla, 2021/2/10  11:16
 */
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[0];
	}

	@Override
	public Predicate<String> getExclusionFilter() {
		return null;
	}
}
