package org.springframework.aa;

import org.springframework.stereotype.Service;

public class Bean1 {

	public Bean2 bean2;

	public String name = "bean1";

	public Bean2 getBean2() {
		return bean2;
	}

	public void setBean2(Bean2 main) {
		this.bean2 = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
