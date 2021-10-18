package com.longmenzhitong.training.conc04;

import java.util.Random;

/**
 * Generator
 */
public class Generator {

    public int gen() {
        try {
            // 模拟子线程处理时间
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextInt();
    }
}
