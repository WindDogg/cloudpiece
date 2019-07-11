package com.one.piece.two;


public class TestThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                int seconds=0;
                while (seconds<10){
                    try {
                        //线程暂停方法sleep()
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n",seconds++);
                }
            }
        };
        t1.setPriority(Thread.MAX_PRIORITY);
        //守护线程
        t1.setDaemon(true);
        t1.start();


       //代码执行到这里，一直是main线程在运行
    /*    try {
            //t1线程加入到main线程中来，只有t1线程结束，才会继续往下走
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread t2 = new Thread(){
            public void run(){
                //临时暂停方法
                Thread.yield();
                System.out.println("验证jion()方法");
            }
        };
        //线程优先级
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}
