package com.careerdevs.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
   private static Scanner scanner =  new Scanner(System.in);

    public static String readString(String question){

        while (true){
            System.out.print(question);
            try{
                String answer = scanner.nextLine();

                while(answer.isBlank()){
                    System.out.println(question);
                    answer = scanner.nextLine();
                }
                return answer.trim();

            } catch (InputMismatchException e){
                System.out.println(question);
                scanner.nextLine();
                System.out.println("Entry invalid, please try again");

            }
        }
    }

    public static int ReadInt(String question, int min, int max) {
        while (true) {
            System.out.print(question + "\nNumber (" + min + " - " + max +"): ");

            try {
                int answer = scanner.nextInt();
                scanner.nextLine();
                while(answer> max || answer<min){
                    System.out.println("you must enter a valid number, please try again");
                    System.out.println(question);
                    answer=scanner.nextInt();
                    scanner.nextLine();
                }
                return answer;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("you must enter an integer, please try again");

            }

        }
    }
    public static char readChar(String question){
        while (true){
            System.out.print(question);
            try{
                String answer = scanner.nextLine();

                while(answer.isBlank() || answer.length()>1||!Character.isAlphabetic(answer.charAt(0))){
                    System.out.println("You must enter one character A-Z");
                    System.out.println(question);
                    answer = scanner.nextLine();
                }
                return answer.charAt(0);

            } catch (InputMismatchException e){
                System.out.println(question);
                scanner.nextLine();
                System.out.println("Entry invalid, please try again");

            }
        }

    }
}
