package com.one.piece.three;

public class Hero {
    public String name;

    public float hp;

    public int damage;

    //回血方法
    public synchronized void recover(){
        hp=hp+1;
    }
    //掉血方法
    public void hurt(){
        synchronized (this){
            hp=hp-1;
        }

    }

    public void attackHero(Hero h){
        h.hp-=damage;
        System.out.printf("%s 正在攻击 %s,%s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if (h.isDead()){
            System.out.println(h.name+"死了！");
        }
    }

    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
