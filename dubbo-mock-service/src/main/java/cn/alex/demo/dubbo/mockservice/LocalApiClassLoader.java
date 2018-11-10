package cn.alex.demo.dubbo.mockservice;

import java.net.URL;
import java.net.URLClassLoader;

public class LocalApiClassLoader extends URLClassLoader {
    public LocalApiClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}
