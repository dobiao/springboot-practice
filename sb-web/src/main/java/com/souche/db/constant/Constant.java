package com.souche.db.constant;

/**
 * 开发框架基础架构的公共常量设置类（行知网络使用此基础框架的项目均可使用此常量类）
 * @author sunny
 *
 */
public interface Constant {
	
	/**失败标识-文字;成功标识-文字*/
	String FAIL_TEXT = "FAIL",UCCESS_TEXT = "SUCCESS";
	
	/**整个应用0表示失败,1表示成功*/
	String FAIL="0",SECCUESS="1";
	
	/**未登录;未授权*/
	String NO_LOGIN = "-1",NO_AUTHORITY = "-2";
	
	/**整个应用0表示否,1表示是*/
	int NO = 0,YES=1;
	
	/**状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	int VIP_STATUS_NO = 0,VIP_STATUS_SUBMIT = 1,VIP_STATUS_OVER = 2;
	
	/**待审核;审核通过;审核不通过*/
	int CENSORED_STATE_NO = 0,CENSORED_STATE_PASS = 1,CENSORED_STATE_NOPASS = 2;
	
	/**禁用;启用*/
	int DISABLED = 0,ENABLED = 1;
	
	/**是否定制:0为否,1为是*/
	int IS_CUSTOMIZED_NO = 0,IS_CUSTOMIZED_YES = 1;
	
	/**高级定制状态（0、未提交，1、已提交待抢单，2、已抢单）*/
	int VIP_CUSTOMIZED_SUBMIT = 0,VIP_CUSTOMIZED_UNCENSOR = 1,VIP_CUSTOMIZED_CENSOR = 0;
	
	/**0为不删除;1为已删除*/
	int DEL_STATE_NO = 0,DEL_STATE_YES = 1;
	
	/**显示1;不显示0*/
	int SHOW_STATE_YES = 1,SHOW_STATE_NO = 0;
	
	/**默认的分页每页记录数*/
	int DEFAULT_PAGE_SIZE = 10;
	
	/**错误信息*/
	String ERR_MSG_INVALID_ARG = "Invalid argument.", //参数无效或不合要求
		   ERR_MSG_EXCEPTION_CATCHED = "Exception catched.", //捕获到异常
		   ERR_MSG_DATA_NOT_EXISTS = "Data not exists."; //数据不存在
	
	/**项目的路径：http://ip:端口*/
	String BASE_PATH = null;
	
	/**图片服务器地址*/
	String IMAGES_SERVICE_URL = null;
	
	/*消息类型*/
	String MESSAGE_HTML ="0", //url消息
		   MESSAGE_ORDER ="1", //订单消息
		   MESSAGE_USER ="2"; //会员信息变更消息
	
	/**第三方认证类型：*/
	String THIRD_OAUTH_QQ ="qq",       //QQ
		THIRD_OAUTH_WEIXIN ="weixin",  //微信
		THIRD_OAUTH_WEIBO ="weibo";    //微博
	
	
	/**短信验证码过期的定时任务时间*/
	long TASK_INTERVAL_TIME = 1000*60*5;
	
	/**短信验证码过期的定时任务时间*/
	int OUT_TIME = 5,// 超时时间为5分钟
		INTERVAL_TIME = 5;//短信验证码发送时间间隔5分钟
	
	/**登录二维码过期的定时任务时间*/
	long TASKQR_INTERVAL_TIME = 1000*60*5;
	
	
	/**系统默认大区和异业联盟*/
	long  DEFAULT_DISTRIBUTORID =60000L,
	      DEFAULT_YIYE_DISTRIBUTORID =60001L;
	
	/**新增用户送优惠券任务开启状体:默认关闭*/
	boolean TASK_MEMBER_COUPON_STATUS =false;
	
	
}
