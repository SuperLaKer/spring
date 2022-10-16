package org.springframework.aop.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Import(Bean3.class)
public class MainBean implements InitializingBean {

	public String env;
	public int num;
	public Bean2 bean2;
	public Bean3 bean3;

	public MainBean() {
		// 黑 红 绿 黄 蓝 紫 深蓝 灰白色
		// 字体颜色30-37;字体样式;背景33-37
		String msg = "MainBean NoArgsConstructor";
		System.out.println("\033[32;1;1m******" + msg + "******\033[0m");
	}

	@PostConstruct
	public void init() {
		System.out.println("...init...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy...");
	}

	@Value("${JAVA_HOME}")
	public void setEnv(String env) {
		this.env = env;
	}

	@Value("10")
	public void setNum(int num) {
		this.num = num;
	}

	@Autowired
	public void setBean2(Bean2 bean2) {
		this.bean2 = bean2;
	}

	@Resource
	public void setInjectBean3(Bean3 bean3) {
		this.bean3 = bean3;
	}

	@Override
	public String toString() {
		return "MainBean{" +
				"env='" + env + '\'' +
				", num=" + num +
				", bean2=" + bean2 +
				", bean3=" + bean3 +
				'}';
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("...afterPropertiesSet...");
	}
}
