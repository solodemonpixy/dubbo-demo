package cn.alex.demo.dubbo.dubbotest.spi;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = "demo1")
public class ExtActiveGroup implements ExtActive1 {
    @Override
    public String sayHello(String msg) {
        return msg;
    }
}
