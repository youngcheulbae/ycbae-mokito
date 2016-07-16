package com.ycbae.mokitoTest;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getList(String name, int age) {
		List<String> list = new ArrayList<String>();
		return list;
	}
}