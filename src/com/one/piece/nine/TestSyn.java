package com.one.piece.nine;

import java.util.concurrent.atomic.AtomicInteger;

public class TestSyn {
    private static int value = 0;
    private static AtomicInteger atomicValue = new AtomicInteger();

    public static void main(String[] args) {
        int number = 100000;
        Thread[] ts1 = new Thread[number];
        for (int i=0;i<number;i++){
            Thread t = new Thread(){
               public void run(){
                   value++;
               }
            };
            t.start();
            ts1[i]=t;
        }
        for(Thread t :ts1){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行value++后，value的值变为%d %n",number,value);
        Thread[] ts2 = new Thread[number];
        for (int i=0;i<number;i++){
            Thread t = new Thread(){
                public void run(){
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            ts2[i]=t;
        }

        for (Thread t : ts2){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet()方法，atmoicValue的值变为：%d%n",number,atomicValue.intValue());
    }
}
