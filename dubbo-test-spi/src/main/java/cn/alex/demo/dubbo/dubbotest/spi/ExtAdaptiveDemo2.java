package cn.alex.demo.dubbo.dubbotest.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

//@Adaptive
public class ExtAdaptiveDemo2 implements ExtAdaptive1{
    @Override
    public String sayHello(URL url) {
        return "demo2";
    }
}
