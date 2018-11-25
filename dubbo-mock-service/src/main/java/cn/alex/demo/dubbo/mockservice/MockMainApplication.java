package cn.alex.demo.dubbo.mockservice;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;

@SpringBootApplication
public class MockMainApplication implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(MockMainApplication.class,args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        URL url = new URL("file:/Users/zhouchushu/work/dubboapi/dubbo-demo-api-1.0-SNAPSHOT.jar");
        LocalApiClassLoader localApiClassLoader = new LocalApiClassLoader(new URL[]{url}, Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(localApiClassLoader);
        Class<?> loadClass = localApiClassLoader.loadClass("cn.alex.demo.dubboapi.HelloService");
        Object proxyInstance = Proxy.newProxyInstance(localApiClassLoader, new Class[]{loadClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String result = "{\"msg\":\"success\",\"code\":999999,\"data\":{\"name\":\"alex\",\"age\":11}}";
                Type returnType = method.getGenericReturnType();
                Object resultOBJ = JSON.parseObject(result, returnType);
                return resultOBJ;
            }
        });


        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-mock");
        application.setLogger("slf4j");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181?client=zkclient");


        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12346);
        protocol.setThreads(200);

        // 服务提供者暴露服务配置
        ServiceConfig<Object> service = new ServiceConfig<>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(loadClass);
        service.setRef(proxyInstance);
        service.setFilter("tracing");

        // 暴露及注册服务
        service.export();


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringExtensionFactory.addApplicationContext(applicationContext);
    }
}
