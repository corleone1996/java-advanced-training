package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Test01
 */
@Slf4j
public class Test01 {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("主线程启动");

        Future<Integer> future = EXECUTOR_SERVICE.submit(() -> new Random().nextInt());
        int ran = future.get();
        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
        EXECUTOR_SERVICE.shutdown();
    }


}
