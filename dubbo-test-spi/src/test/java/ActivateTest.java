import cn.alex.demo.dubbo.dubbotest.spi.ExtActive1;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.List;

public class ActivateTest {

    @Test
    public void test(){
        ExtensionLoader<ExtActive1> extensionLoader = ExtensionLoader.getExtensionLoader(ExtActive1.class);
        URL url = URL.valueOf("test://localhost?key1=dd");
        List<ExtActive1> demo1 = extensionLoader.getActivateExtension(url, new String[]{},"demo1");
        System.out.println(demo1.size());
        for (ExtActive1 extActive1 : demo1) {
            System.out.println(extActive1.getClass().getName());
        }

    }

}
