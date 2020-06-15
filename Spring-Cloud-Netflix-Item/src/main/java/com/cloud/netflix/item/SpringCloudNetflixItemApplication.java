package com.cloud.netflix.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "servicio-productos") //Feign is integrated into Ribbon so that Feign could consume based-on load balancing.
//Both the url and the port are coupled in ribbon
//Url and port are define in the application-properties file
@EnableFeignClients //Netflix's client Rest Annotation. With this we can inject client feign into classes
@SpringBootApplication
public class SpringCloudNetflixItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNetflixItemApplication.class, args);
	}

}
