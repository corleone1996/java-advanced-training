package com.longmenzhitong.training.conc04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Test01
 */
@Slf4j
public class Test01 {

    private static final ExecutorService THREAD_POOL;

    static {
        int processors = Runtime.getRuntime().availableProcessors();
        int corePoolSize = processors + 1;
        int maximumPoolSize = processors * 2;
        long keepAliveTime = 60L;
        THREAD_POOL = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("主线程启动");

        Future<Integer> future = THREAD_POOL.submit(() -> new Generator().gen());
        int ran = future.get();
        log.info("生成随机数：{}", ran);

        log.info("主线程结束");
        THREAD_POOL.shutdown();
    }


}
