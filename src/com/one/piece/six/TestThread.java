package com.one.piece.six;

import com.one.piece.three.Hero;
public class TestThread {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 209;

        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    //因为减血更快，所以盖伦的血量迟早会达到1
                    //使用while循环判断是否是1，如果是1就停止减血
                    while(gareen.hp>1){
                        gareen.hurt();
                        System.out.printf("t1 为%s减血1点，减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);;
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
          public void run(){
              while (true){
                  gareen.recover();
                  System.out.printf("t2 为%s恢复一点血，恢复后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

          }
        };
        t2.start();
    }
}
