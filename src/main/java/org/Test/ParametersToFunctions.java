package org.Test;

public class ParametersToFunctions {
    public static double calculatetotalmealprice(double mealprice,double tax,double tiprate){
        double tip=tiprate*mealprice;
        double taxrate=tax*mealprice;
        double result=tiprate+tax+mealprice;
        System.out.println("THe total meal price is "+result);
        return result;
    }
    public static void main(String[] args) {
        double groupmealprice= calculatetotalmealprice(20.5,0.9,10.9);
        double indivialcontribution=groupmealprice/3;
        System.out.println("THe individual contribution is "+indivialcontribution);

    }
}
