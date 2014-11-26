Market
======

商城购物管理系统

##运行环境
* eclipse
* SQL Server

##配置项目
###1. 下载该项目
###2. 配置eclipse
在eclipse中新建项目，路径选择该项目的路径。

###3. 添加额外rt.jar
如果你的jdk是java8之前的那么不需要这一步。  
如果是java8，那么需要下载老版本的jdk，然后在组建路径（Build Path）中添加rt.jar
>因为java8中的rt.jar文件中，移除了JDBC-ODBC的桥接驱动。  
>rt.jar在jre目录下的lib目录下。

