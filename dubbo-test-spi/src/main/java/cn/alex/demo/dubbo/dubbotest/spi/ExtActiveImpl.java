package cn.alex.demo.dubbo.dubbotest.spi;

import org.apache.dubbo.common.extension.Activate;

@Activate
public class ExtActiveImpl implements ExtActive1 {
    @Override
    public String sayHello(String msg) {
        return null;
    }
}
