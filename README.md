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

5. 使用mybatis 拦截器进行分页的插件

6. springSecurity 默认设置在spring.profiles.active=prod时生效,如想关闭请设置为dev

7. 使用google guva EventBus 进行发布/订阅模式的事件监听进行解耦。see： ```https://github.com/google/guava/wiki/EventBusExplained```

```
注意：此时/permit/** /auth 接口均不可使用
```

last. 问题反馈：woxiaoxinxin@gmail.com

