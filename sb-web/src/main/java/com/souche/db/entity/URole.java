package com.souche.db.entity;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;



/**
 * @Title: URole.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:12:26
 * @version V1.0   
 */
@Data
@JsonInclude(Include.NON_NULL)
public class URole  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Long id;//
	private String name;//角色名称
	private String type;//角色类型
	
}
