package com.longmenzhitong.training.nio02;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * HttpClient工具
 *
 * @author longmenzhitong
 * @since 2021/9/26 12:58
 */
@Slf4j
public class HttpClientTool {

  public static void main(String[] args) {
    get("http://localhost:8081");
  }

  public static HttpEntity get(String addr) {
    HttpGet get = new HttpGet(addr);
    try (CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse resp = client.execute(get)) {
      log.info("响应状态：{}", resp.getStatusLine());

      HttpEntity entity = resp.getEntity();
      log.info("响应体：{}", entity);

      return entity;
    } catch (IOException e) {
      log.error("请求异常，请求地址: {}", addr, e);
    }

    return null;
  }
}
