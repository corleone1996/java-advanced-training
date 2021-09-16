package com.longmenzhitong.training.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件读取器
 *
 * @author longmenzhitong
 * @since 2021-09-16
 */
public class FileReader {

  private FileReader() {
  }

  public static byte[] readByteArray(String filePath) throws IOException {
    byte[] data;
    try (InputStream in = new FileInputStream(filePath)) {
      data = toByteArray(in);
    }
    return data;
  }

  private static byte[] toByteArray(InputStream in) throws IOException {
    byte[] res;
    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      byte[] buffer = new byte[1024 * 4];
      int n;
      while ((n = in.read(buffer)) != -1) {
        out.write(buffer, 0, n);
      }
      res = out.toByteArray();
    }
    return res;
  }
}
