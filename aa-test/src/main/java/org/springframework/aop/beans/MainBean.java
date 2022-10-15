package org.springframework.aop.beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;


@Data
@ToString
@Import(Bean3.class)
public class MainBean {

	@Value("${JAVA_HOME}")
	public String env;

	@Value("10")
	public int num;
	@Autowired
	public Bean2 bean2;

	@Resource
	public Bean2 injectBean3;

	public void init() {
		System.out.println("init...");
	}
}
