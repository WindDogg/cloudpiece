package com.one.piece.three;

public class TestThread {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;
        System.out.printf("盖伦的初始血量是%.0f%n",gareen.hp);
        //多线程同步问题指的是多个线程同时修改一个数据时，导致的问题
        //假设盖伦有10000滴血，并且在基地里，同时又被多个英雄攻击
        //用java代码来表示，就是有多个线程在减少盖伦的hp,同时又有多个线程在恢复盖伦的hp

        //n个线程增加盖伦的hp
        int n = 10000;

        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        for (int i=0;i<addThreads.length;i++){
            Thread t = new Thread(){
                public void run(){
                    synchronized (gareen){
                        gareen.recover();
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        //n个减少盖伦hp 的线程
        for (int i=0;i<n;i++){
            Thread t = new Thread(){
              public void run(){
                  synchronized (gareen){
                      gareen.hurt();
                  }

                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            };
            t.start();
            reduceThreads[i] = t;
        }

        for (Thread t :addThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread t: reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成 %.0f%n",n,n,gareen.hp);

    }
}
