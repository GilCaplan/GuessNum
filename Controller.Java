package com.example.findrandomnumber;

public class Controllerguessnum {

    private Modelguessnum myModel1;
    public double counter=0;
    private int random;

    public Controllerguessnum(){
        myModel1= new Modelguessnum();
        cstartGame();
        this.counter=0;
    }
    public void cstartGame(){
        myModel1.mStartGame();
        this.counter=0;    }

    public void cplus(){
        myModel1.mplus();
    }
    public void cminus(){
        myModel1.mminus();
    }
    public void ccntplus(){
        this.counter++;
    }


    public String ccheck(){

        String res = myModel1.mcheck();
        return res;
    }

    public double ccurrentnum(){
        int cnum=myModel1.getCurrentnum();
        return cnum;

    }

    public double ccounter(){
        double cnt= this.counter;
        return cnt;
}
    public int crandom(){
        this.random = myModel1.getRandomnum();
        return this.random;
}
}
