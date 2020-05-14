# springCloud学习

![](./images/1.png)

## 服务调用2

### ❌feign（假装）
* 是什么👻：服务提供端的负载均衡，服务调用端只需创建一个借口，添加注解，即可实现
![](./images/2.png)
* 为什么要用
![](./images/3.png)

### ✅openFeign
* 与feign的区别
![](./images/4.png)

	#### openFeign使用
	
	1. pmo.xml
		
		```
		 <!--openFeign-->
	        <dependency>
	            <groupId>org.springframework.cloud</groupId>
	            <artifactId>spring-cloud-starter-openfeign</artifactId>
	        </dependency>
		```
	2. application.properties

		```
		spring.main.allow-bean-definition-overriding=true
		```

	
	3. 主启动类
		* 服务调用端 添加@EnableFeignClients
		
			```
			@EnableFeignClients		// 使用该注解启用openFeign
			```
	4. 业务类
		* 定义一个接口
			
			```
			@Component
			@FeignClient(value = "cloud-provider-consul-payment")   //要用OpenFeign负载均衡的服务
			public interface PaymentFeignService {
			
			    @GetMapping("/getport")  // 具体服务的接口
			    String getPort();
			}
			```
	