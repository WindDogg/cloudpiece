package com.one.piece.five;
import com.one.piece.one.Hero;
public class TestThread {
    public static void main(String[] args) {
        final Hero ahri = new Hero();
        ahri.name = "九尾妖狐";
        final Hero annie = new Hero();
        annie.name = "安妮";

        Thread t1 = new Thread(){
          public void run(){
              synchronized (ahri){
                  System.out.println("t1 已占有九尾妖狐");
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("t1 试图占有安妮");
                  System.out.println("t1 等待中。。。");
                  synchronized (annie){
                      System.out.println("do something");
                  }
              }
          }
        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              synchronized (annie){
                  System.out.println("t2 已占有安妮");

                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("t2 试图占有九尾妖狐");
                  System.out.println("t2 等待中。。。");
                  synchronized (ahri){
                      System.out.println("t2 do something");
                  }

              }

          }
        };
        t2.start();
    }

}
