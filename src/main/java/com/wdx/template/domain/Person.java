package com.wdx.template.domain;

import java.util.Date;

public class Person {

	private Long id;

	private String name;

	private String email;

	private Integer age;

	private Date birthDay;

	public Person() {
	}

	public Person(Long id, String name, String email, Integer age, Date birthDay) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.birthDay = birthDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", birthDay=" + birthDay
				+ "]";
	}

}
