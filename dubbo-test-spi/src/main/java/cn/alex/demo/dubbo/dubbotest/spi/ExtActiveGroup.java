package cn.alex.demo.dubbo.dubbotest.spi;


import org.apache.dubbo.common.extension.Activate;

@Activate(group = "default_group")
public class ExtActiveGroup implements ExtActive1 {
    @Override
    public String sayHello(String msg) {
        return msg;
    }
}
