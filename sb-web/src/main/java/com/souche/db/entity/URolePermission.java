package com.souche.db.entity;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;



/**
 * @Title: URolePermission.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:12:46
 * @version V1.0   
 */
@Data
@JsonInclude(Include.NON_NULL)
public class URolePermission  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
	private Long rid;//角色ID
	private Long pid;//权限ID
}
