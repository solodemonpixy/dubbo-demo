package cn.alex.demo.dubbo.dubbotest.spi;


import org.apache.dubbo.common.extension.Activate;

@Activate(group = "default_group2")
public class ExtActiveGroup2 implements ExtActive1 {
    @Override
    public String sayHello(String msg) {
        return msg;
    }
}
