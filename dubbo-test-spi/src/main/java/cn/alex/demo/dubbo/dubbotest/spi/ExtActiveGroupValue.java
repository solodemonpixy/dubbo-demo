package cn.alex.demo.dubbo.dubbotest.spi;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = "demo2",value = "key1")
public class ExtActiveGroupValue implements ExtActive1{
    @Override
    public String sayHello(String msg) {
        return msg;
    }
}
