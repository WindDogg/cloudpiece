package com.one.piece;

public class KillThread extends Thread{
    private Hero hero_one;
    private Hero hero_two;

    public KillThread(Hero h1,Hero h2){
        hero_one = h1;
        hero_two = h2;
    }
    public void run(){
        while(!hero_two.isDead()){
            hero_one.attackHero(hero_two);
        }
    }
}
