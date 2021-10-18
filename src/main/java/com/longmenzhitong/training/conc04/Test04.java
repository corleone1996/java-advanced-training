package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * Test02
 */
@Slf4j
public class Test04 {

    static volatile Integer ran;

    public static void main(String[] args) throws InterruptedException {
        log.info("主线程启动");

        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            ran = new Generator().gen();
            latch.countDown();
        }).start();

        latch.await();
        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
    }


}
