package org.Test;

public class StaticVariable {
    String name;
    int Class;
    static String Teacher;

    public void section(){
        System.out.println(name+" : "+Class+" : "+Teacher);
    }

    public static void main(String[] args) {
        StaticVariable ob=new StaticVariable();
        StaticVariable ob1=new StaticVariable();
        ob.name="HIgher Class";
        ob.Class=10;
        StaticVariable.Teacher="Good Teacherrrrr";

        ob1.name="HIgher Class";
        ob1.Class=10;
        StaticVariable.Teacher ="Good Teacherrrrrrrrr";

       // ob.name="Ram";
        ob.section();
        ob1.section();
    }

}
