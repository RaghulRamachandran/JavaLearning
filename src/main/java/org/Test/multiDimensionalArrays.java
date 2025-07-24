package org.Test;

public class multiDimensionalArrays {
    public static void main(String[] args) {


    int a [][]=new int[8][9];
    for(int i=0;i<8;i++){
        for(int j=0;j<9;j++){
            System.out.print(a[i][j] +" ");
        }
        System.out.println();
    }
    String z=new String("Ram");
        System.out.println(z);

        StringBuffer ab=new StringBuffer("Ramachandran");
        ab.append( "chandran");
        ab.insert(3,"Java");
        ab.setLength(50);
        System.out.println(ab);
        String Str=ab.toString();
        System.out.println(Str);

}}
