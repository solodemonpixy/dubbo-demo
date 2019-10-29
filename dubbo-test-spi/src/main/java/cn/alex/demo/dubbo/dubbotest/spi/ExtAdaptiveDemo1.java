package cn.alex.demo.dubbo.dubbotest.spi;


import org.apache.dubbo.common.URL;

public class ExtAdaptiveDemo1 implements ExtAdaptive1 {
    @Override
    public String sayHello(URL url) {
        return "demo1";
    }
}
