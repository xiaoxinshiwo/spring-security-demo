# 使用说明
1. 登录 
```
http://127.0.0.1:8080/login

```
2. 用户列表 刷入脚本 mysql.sql
```
admin/admin permissions: user-create user-update
user/user permissions: user-update
zhangsan/zhangsan permissions:none
```
3. bug fix ```No ServletContext set```
see :https://stackoverflow.com/questions/48367588/spring-boot-with-aclpermissionevaluator-resulting-in-illegalstateexception-no-s

4. 使用mybatis-spring-boot-starter

5. 已知问题：使用mybatis 拦截器进行分页的插件不起作用

last. 问题反馈：woxiaoxinxin@gmail.com