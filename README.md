#SpringBoot实战项目

## 目前整合了mybatis和swagger

##启动应用步骤：
#####1、本地新建MySQL数据库demo，导入数据表（下面有create user table）;
#####2、运行 
```
mvn spring-boot:run
log出现：Tomcat started on port(s): 8080 (http)，证明启动成功
```
##访问API文档:
http://localhost:8080/swagger/index.html 即可在线查看API手册和调试API。


##创建数据库
create user table:
```
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `name`, `age`, `password`)
VALUES
	(1,'dobiao',18,'123456');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

```


## 如果部署到Tomcat中，需要稍微修改一下

### 修改pom.xml文件

官方参考：
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging

```

	<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	    <!-- ... -->
	    <packaging>war</packaging>
	    <!-- ... -->
	    <dependencies>
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-web</artifactId>
	        </dependency>
	        <dependency>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-starter-tomcat</artifactId>
	            <scope>provided</scope>
	        </dependency>
	        <!-- ... -->
	    </dependencies>
	</project>

```

将包改成 war，加入tomcat的scope为 provided，这样部署到TOMCAT就不会启动内置的tomcat了。

### 修改启动类

官方参考：
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file

```

	@SpringBootApplication
	public class Application extends SpringBootServletInitializer {
	
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	
	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
	    }
	
	}

```

将你的启动类改成以上样式。 mvn package 打包，并把target下的war包部署到TOMCAT即可。



## 任何新的需求建议，bug提交，贡献请加入联系我，QQ：909025298