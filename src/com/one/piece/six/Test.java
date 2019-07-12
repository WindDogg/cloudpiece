package com.one.piece.six;

import com.one.piece.one.Hero;

public class Test {
    public static void main(String[] args) {
        final HeroJh gareen = new HeroJh();
        gareen.name = "盖伦";
        gareen.hp = 198;

        Thread t1 = new Thread(){
          public void run(){
              while(true){
                  gareen.hurt();
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
