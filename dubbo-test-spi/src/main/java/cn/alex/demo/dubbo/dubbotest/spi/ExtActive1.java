package cn.alex.demo.dubbo.dubbotest.spi;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface ExtActive1 {

    String sayHello(String msg);

}
