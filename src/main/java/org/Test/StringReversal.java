package org.Test;

public class StringReversal {
    public static void main(String[] args) {
        String a ="Ramaaa";
        StringBuffer bc=new StringBuffer(String.valueOf(a));
        StringBuffer rev =bc.reverse();
        System.out.println(rev);
//        String rev="";
//
//        for(int i=a.length()-1;i>=0;i++){
//            rev=rev+a.charAt(i);
//        }
//        System.out.println(rev);
        }
    }

