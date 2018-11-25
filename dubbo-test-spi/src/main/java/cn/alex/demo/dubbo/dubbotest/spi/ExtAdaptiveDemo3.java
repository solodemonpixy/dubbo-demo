package cn.alex.demo.dubbo.dubbotest.spi;

import com.alibaba.dubbo.common.URL;

public class ExtAdaptiveDemo3 implements ExtAdaptive1 {
    @Override
    public String sayHello(URL url) {
        return "demo3";
    }
}
