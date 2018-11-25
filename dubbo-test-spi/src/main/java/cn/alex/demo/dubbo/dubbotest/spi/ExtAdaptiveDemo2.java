package cn.alex.demo.dubbo.dubbotest.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

@Adaptive
public class ExtAdaptiveDemo2 implements ExtAdaptive1{
    @Override
    public String sayHello(URL url) {
        return "demo2";
    }
}
