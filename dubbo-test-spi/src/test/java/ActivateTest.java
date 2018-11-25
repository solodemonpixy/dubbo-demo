import cn.alex.demo.dubbo.dubbotest.spi.ExtActive1;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.List;

public class ActivateTest {

    @Test
    public void test(){
        ExtensionLoader<ExtActive1> extensionLoader = ExtensionLoader.getExtensionLoader(ExtActive1.class);
        URL url = URL.valueOf("test://localhost?ss=v1");
        List<ExtActive1> demo1 = extensionLoader.getActivateExtension(url, new String[]{"groupValue"}, "demo2");
        System.out.println(demo1.size());
        System.out.println(demo1.get(0).getClass());
    }

}
