package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Test02
 */
@Slf4j
public class Test05 {

    static volatile Integer ran;

    public static void main(String[] args) throws InterruptedException {
        log.info("主线程启动");

        CyclicBarrier barrier = new CyclicBarrier(1);
        new Thread(() -> {
            ran = new Generator().gen();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
    }


}
