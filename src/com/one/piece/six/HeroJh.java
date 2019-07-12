package com.one.piece.six;

public class HeroJh {

    public String name;
    public float hp;
    public int damage;

    public synchronized  void recover(){
        hp=hp+1;
        System.out.printf("%s 回血1点，增加血后，%s的血量是%.0f%n",name,name,hp);
        //通知那些等待在this对象上的线程，可以醒过来了
        this.notify();
    }

    public synchronized void hurt(){
        if (hp==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp=hp-1;
        System.out.printf("%s 掉血2点,减少血后,%s的血量是%.0f%n",name,name,hp);
    }
}
