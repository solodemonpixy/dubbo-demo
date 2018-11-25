import cn.alex.demo.dubbo.dubbotest.spi.ExtAdaptive1;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class AdaptiveTest {

    @Test
    public void test(){
        ExtensionLoader<ExtAdaptive1> extensionLoader = ExtensionLoader.getExtensionLoader(ExtAdaptive1.class);
        ExtAdaptive1 adaptiveExtension = extensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost:8080?d=demo1");
        System.out.println(adaptiveExtension.sayHello(url));
    }

}
