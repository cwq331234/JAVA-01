package work;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Hello.xlass"));
        byte[] bs = new byte[inputStream.available()];
        inputStream.read(bs);
        for (int i = bs.length - 1; i >= 0; i--) {
            bs[i] = (byte) ((byte) 255 - bs[i]);
        }
        Class clazz = new HelloClassLoader().defind(bs);
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());
    }

    private Class defind(byte[] bs) {
        return defineClass("Hello", bs, 0, bs.length);
    }
}