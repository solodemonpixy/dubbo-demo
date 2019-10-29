package cn.alex.demo.dubbo.dubbotest.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;


@SPI("demo1")
public interface ExtAdaptive1 {

    @Adaptive("d")
    String sayHello(URL url);

}
