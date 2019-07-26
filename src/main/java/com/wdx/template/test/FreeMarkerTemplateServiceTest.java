package com.wdx.template.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wdx.template.domain.Person;
import com.wdx.template.service.FreeMarkerTemplateService;
import com.wdx.template.service.PersonService;

import cn.hutool.core.lang.Dict;

/**
 * 描述：测试模板
 * @author 80002888
 * @date   2019年7月26日
 */
public class FreeMarkerTemplateServiceTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 测试模板
	 *	@ReturnType	void 
	 *	@Date	2019年7月26日	下午2:14:37
	 *  @Param
	 */
	@Test
	public void templateTest001(){
		// 模板文件名字
		String templateName = "cp1.ftl";
		// 设置参数内容
		Dict dict = Dict.create();
		dict.set("intValue", 15);
		dict.set("longValue", 10000L);
		dict.set("doubleValue", 18.88);
		dict.set("stringValue", "李四");
		dict.set("booleanValue", true);
		dict.set("dateValue", new Date());
		dict.set("nullValue", null);
		dict.set("person", new Person(1L, "张三", "zhangsan@163.com", 22, new Date()));
		dict.set("htmlValue", "<font color='red'>我只想早点下班，对不起，你是程序员！</font>");
		dict.set("persons", PersonService.getAll());
		Map<String, Object> map = new HashMap<>();
		map.put("java", "爪哇");
		map.put("python", "皮森");
		map.put("haha", "哈哈");
		dict.set("map", map);
		String result = null;
		try {
			// 获取内容
			result = FreeMarkerTemplateService.getStringFromTemplate(templateName, dict);
		} catch (Exception e) {
			logger.error("get error->" + templateName, e);
		}
		// 打印
		System.out.println(result);
	}
	
}
