package com.example.findrandomnumber;

import java.util.Random;

public class Modelguessnum {
    private int currentnum=0;
    private int  randomnum=0;
    private  int counter=0;

    public Modelguessnum() {
        this.currentnum= currentnum;
        this.randomnum= randomnum;
        this.counter=counter;
    }
    public void mStartGame(){
        this.randomnum= new Random().nextInt( 100);
        this.currentnum= new Random().nextInt(100);
    }
    public int getCurrentnum(){
        int mnum= currentnum;
        return mnum;
    }
    public int getRandomnum(){
        return randomnum;
    }


    public void mplus(){
        this.currentnum++;
    }
    public void mminus()
    {
        this.currentnum--;
    }

    public String mcheck() {
        //-1 is smaller
        //0 equal
        //1 is bigger
        if (this.currentnum > this.randomnum) {
            return "bigger";
        }
        else
          if (this.currentnum==this.randomnum){
               return "equal";
        }

        else
            if(this.currentnum < this.randomnum){
                return "smaller";
            }
        else
           return "neither";
}
}
