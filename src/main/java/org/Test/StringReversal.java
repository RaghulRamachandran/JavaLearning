package org.Test;

public class StringReversal {
    public static void main(String[] args) {
        String a ="ayrawsIsevolnardnahcamaR";
//        StringBuffer bc=new StringBuffer(String.valueOf(a));
//        StringBuffer rev =bc.reverse();
//        System.out.println(rev );
        String rev="";
        int len=a.length();
        for(int i=len-1;i>=0;i--){
            rev=rev+a.charAt(i);
        }
        System.out.println(rev);
        }
    }

