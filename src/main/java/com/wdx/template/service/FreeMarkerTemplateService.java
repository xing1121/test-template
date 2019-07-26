package com.wdx.template.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateConfig.ResourceMode;
import cn.hutool.extra.template.engine.freemarker.FreemarkerEngine;

/**
 * 描述：FreeMarkerTemplateService
 * @author 80002888
 * @date   2019年7月26日
 */
public class FreeMarkerTemplateService {
	
	private static Logger logger = LoggerFactory.getLogger(FreeMarkerTemplateService.class);

	/**
	 * 根据类路径下templates文件夹内模板文件名称，获取内容
	 * 	如类路径下的templates/123.ftl，则传入123.ftl
	 *	@ReturnType	String 
	 *	@Date	2019年7月26日	下午2:24:42
	 *  @Param  @param templateName
	 *  @Param  @return
	 */
	public static String getStringFromTemplate(String templateName, Dict dict){
		// 获取单例的Freemarker引擎
		FreemarkerEngine engine = getFreemarkerEngineInstance();
		// 加载指定模板文件
		Template templateFile = null;
		try {
			templateFile = engine.getTemplate(templateName);
		} catch (Exception e) {
			logger.error("get error->" + templateName , e);
		}
		if (templateFile == null) {
			return null;
		}
		// 根据参数内容渲染页面，返回页面字符串
		return templateFile.render(dict);
	}
	
	/**
	 * 描述：FreemarkerEngine单例对象持有者
	 * @author 80002888
	 * @date   2019年7月26日
	 */
	private static class FreemarkerEngineSingletonHolder {
		// 创建配置，指定模板文件夹
		private static TemplateConfig config = new TemplateConfig("templates", ResourceMode.CLASSPATH);
		// 创建Freemarker模板引擎
		private static FreemarkerEngine singleton = new FreemarkerEngine(config);
	}
	
	/**
	 * 获取单例FreemarkerEngine
	 *	@ReturnType	FreemarkerEngine 
	 *	@Date	2019年7月26日	下午2:21:51
	 *  @Param  @return
	 */
	public static FreemarkerEngine getFreemarkerEngineInstance(){
		return FreemarkerEngineSingletonHolder.singleton;
	}
	
}
