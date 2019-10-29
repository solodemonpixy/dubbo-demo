package cn.alex.demo.dubbo.dubbotest.spi;


import org.apache.dubbo.common.extension.Activate;

@Activate(group = "demo1",value = "key1")
public class ExtActiveGroupValue implements ExtActive1{
    @Override
    public String sayHello(String msg) {
        return msg;
    }
}
