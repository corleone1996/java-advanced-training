package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

/**
 * Test02
 */
@Slf4j
public class Test03 {

    static volatile Integer ran;

    public static void main(String[] args) throws InterruptedException {
        log.info("主线程启动");

        Thread t = new Thread(() -> ran = new Generator().gen());
        t.start();
        t.join();

        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
    }


}
