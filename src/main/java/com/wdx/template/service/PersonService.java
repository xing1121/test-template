package com.wdx.template.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wdx.template.domain.Person;

/**
 * 描述：PersonService
 * @author 80002888
 * @date   2018年8月24日
 */
public class PersonService {

	/**
	 * 获取所有Person
	 *	@ReturnType	List<Person> 
	 *	@Date	2018年8月24日	上午10:55:15
	 *  @Param  @return
	 */
	public static List<Person> getAll(){
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			persons.add(new Person((long)i, "人物" + i, "haha" + i + "@qq.com", 2*i, new Date()));
		}
		
		return persons;
	}
	
}
