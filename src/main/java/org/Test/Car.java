package org.Test;

public class Car extends Vehicle{
        String model="Zeta";
        public void showDetails(){
            System.out.println("brand"+brand);
            System.out.println("model"+model);
        }

    public static void main(String[] args) {
        Car a=new Car();
        Vehicle c=new Car();
        a.showDetails();
        a.startEngine();
        c.rideVehicle();

    }
}
