package cn.alex.demo.dubbo.dubbotest.spi;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;


public class ExtAdaptiveDemo1 implements ExtAdaptive1 {
    @Override
    public String sayHello(URL url) {
        return "demo1";
    }
}
