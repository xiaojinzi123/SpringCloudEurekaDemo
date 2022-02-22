package com.xiaojinzi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
@EnableEurekaClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        String res = restTemplate.getForObject("http://server/helloServer", String.class);
        return "hello, 我是 server client, 我调用 server 返回的信息是: " + res;
    }

}