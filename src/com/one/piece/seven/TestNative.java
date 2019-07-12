package com.one.piece.seven;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * java自带的线程池
 */
public class TestNative {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,15,60,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
    }
}
