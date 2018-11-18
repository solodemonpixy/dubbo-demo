package cn.alex.demo.dubboconsumer.controller;

import cn.alex.demo.dubboapi.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference(check = false,filter = {"tracing"})
    private HelloService helloService;

    @RequestMapping("/testHello")
    public String hello(String name){
        String result = helloService.hello(name);
        return "hello test"+result;
    }

    @RequestMapping("/getName")
    public Object getName(String name,Integer age){
        return helloService.getName(name,age);
    }

}
