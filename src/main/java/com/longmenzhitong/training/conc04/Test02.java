package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

/**
 * Test02
 */
@Slf4j
public class Test02 {

    static volatile Integer ran;

    public static void main(String[] args) {
        log.info("主线程启动");

        new Thread(() -> {
            ran = new Generator().gen();
        }).start();

        while (ran == null) {
            // 等子线程处理完成
        }

        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
    }


}
