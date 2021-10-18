package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Test02
 */
@Slf4j
public class Test02 {

    static volatile Integer ran;

    public static void main(String[] args) {
        log.info("主线程启动");

        new Thread(() -> {
            try {
                // 模拟子线程处理时间
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ran = new Random().nextInt();
        }).start();

        while (ran == null) {
            // 等子线程处理完成
        }

        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
    }


}
