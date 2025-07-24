package org.Test;

public class moreMethods {
    public  String getMeAPen(){
        return "Pen";
    }
    public void playMusic(){
        System.out.println("Music Playing");
    }
    public static void main(String[] args) {
        moreMethods a=new moreMethods();
        String str=a.getMeAPen();
        System.out.println(str);
        a.playMusic();

    }
}
