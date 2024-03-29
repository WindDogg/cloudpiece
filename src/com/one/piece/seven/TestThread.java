package com.one.piece.seven;

public class TestThread {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;
        while(true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
/*        for (int i=0;i<5;i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };
            pool.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
