package cn.alex.demo.dubbo.dubbotest.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("demo1")
public interface ExtAdaptive1 {

    @Adaptive("d")
    String sayHello(URL url);

}
