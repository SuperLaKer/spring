package org.springframework.aop.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;


@Import(Bean3.class)
public class MainBean {


	public String env;


	public int num;

	public Bean2 bean2;


	public Bean2 injectBean3;

	public void init() {
		System.out.println("init...");
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
	public void setInjectBean3(Bean2 injectBean3) {
		this.injectBean3 = injectBean3;
	}
}
