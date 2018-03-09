package com.souche.db.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;



/**
 * @Title: UUser.java 
 * @Package com.xm.shiro.admin.entity
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author bamboo  <a href=
 *         "mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题："
 *         Bamboo</a>   
 * @date 2017-5-10 0:13:08
 * @version V1.0   
 */
@Data
@JsonInclude(Include.NON_NULL)
public class UUser  implements Serializable {
	 /** serialVersionUID. */
 	private static final long serialVersionUID =1493049839167L;
 	
	private Long id;//
	private String nickname;//用户昵称
	private String email;//邮箱|登录帐号
	private String pswd;//密码
	private Date createTime;//创建时间
	private Date lastLoginTime;//最后登录时间
	private Long status;//1:有效，0:禁止登录
	private List<String> roleStrlist;
	private List<String> perminsStrlist;
}
