package org.smartframework.cloud.starter.configure.properties;

import org.smartframework.cloud.common.pojo.Base;

import lombok.Getter;
import lombok.Setter;

/**
 * swagger配置信息
 * 
 * @author liyulin
 * @date 2019-06-18
 */
@Getter
@Setter
public class SwaggerProperties extends Base {

	private static final long serialVersionUID = 1L;
	/** swagger开关 （默认false） */
	private boolean enable = false;
	/** 项目分组 */
	private String groupName;
	/** 接口文档标题 */
	private String title;
	/** 项目描述 */
	private String description;
	/** 作者姓名 */
	private String name;
	/** 作者网站url */
	private String url;
	/** 作者邮箱 */
	private String email;
	/** 上传yapi配置信息 */
	private UploadYapiProperties uploadYapi = new UploadYapiProperties();

	/** yapi配置信息 */
	@Getter
	@Setter
	public static class UploadYapiProperties extends Base {
		private static final long serialVersionUID = 1L;
		/** 上传yapi开关 （默认true） */
		private boolean enable = true;
		/** yapi项目url */
		private String projectUrl;
		/** yapi项目的token */
		private String token;
		/** 数据同步方式（默认为"merge"，即完全覆盖）：normal"(普通模式) , "good"(智能合并), "merge"(完全覆盖) 三种模式 */
		private String merge = "merge";
	}

}