## A Skywalking demo

![Architecture](https://s1.ax1x.com/2020/07/09/UnRvFO.md.png)

- 网关服务：使用zuul实现，端口：8000；
- 注册中心：使用Eureka实现，端口：8761；
- 用户服务：提供RESTful API的用户服务，使用Spring MVC实现；该服务会调用产品服务，端口：8081；
- 产品服务：提供RESTful API的产品服务，使用Spring MVC实现，使用了一个H2数据库，端口：8082；
- Web服务：外部用户通过该服务来访问系统各项服务，这里使用curl命令模拟: `curl http://localhost:8000/user-service/users/1`

具体使用见我的博客：[APM SkyWalking基本使用介绍](https://niyanchun.com/skywalking-introduction.html)