package org.Test.Test;
public class studentRecord {

    public studentRecord(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    private String name;
    private int   rollNumber;
    private String grade;

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }


    public void setGrade(String grade) {
      if(grade.equals("A")||grade.equals("B")||grade.equals("C")||grade.equals("D")||grade.equals("F")){
          System.out.println("Valid grade");
      }else {
          System.out.println("Invalid grade");
      }

    }
    public void printDetails(){
        System.out.println("Student name"+name);
        System.out.println("Student roll number"+rollNumber);
        System.out.println("grade"+grade);
    }

    public static void main(String[] args) {
        studentRecord r=new studentRecord("Rama",23,"A");
        r.setGrade("Z");
        r.getGrade();
        r.setName("Iswarya");
        r.getName();
        r.printDetails();

    }




}
