package com.longmenzhitong.training.jvm01;

import com.longmenzhitong.training.util.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.StringUtils;

/**
 * Xlass加载器
 *
 * @author longmenzhitong
 * @since 2021-09-16
 */
public class XlassLoader extends ClassLoader {

  /**
   * 待加载的文件所在目录
   */
  private static final String DIR = "src/main/resources/jvm/";
  /**
   * 待加载的文件后缀
   */
  private static final String SUFFIX = ".xlass";

  public static void main(String[] args) throws Exception {
    String filePath = "Hello";
    String methodName = "hello";

    Class<?> cls = new XlassLoader().loadClass(filePath);
    Method method = cls.getMethod(methodName);
    Object obj = cls.getDeclaredConstructor().newInstance();
    method.invoke(obj);
  }

  @Override
  protected Class<?> findClass(String name) {
    if (StringUtils.isBlank(name)) {
      return null;
    }

    String path = DIR + name + SUFFIX;
    byte[] origin;
    try {
      origin = FileReader.readByteArray(path);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return defineClass(name, decode(origin), 0, origin.length);
  }

  private byte[] decode(byte[] origin) {
    byte[] decoded = new byte[origin.length];
    for (int i = 0; i < origin.length; i++) {
      decoded[i] = (byte) (255 - origin[i]);
    }
    return decoded;
  }

}
