package org.Test;

import java.util.Scanner;

public class LogicalOPerators {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("You are playing a game Press q or Q to quit the game");
        String response= scanner.next();
        if(response.equals("q")||response.equals("Q")){
            System.out.println("You can quit the game");
        }else{
            System.out.println("You can continue the game");
        }
    }
}
