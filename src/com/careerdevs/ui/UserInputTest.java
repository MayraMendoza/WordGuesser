package com.careerdevs.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputTest {
    private static Scanner scanner =  new Scanner(System.in);


    /*
    This method will read ONE alphabetical letter entered by a user.
     it will keep asking for an input if the user enters more than ONE LETTER, A BLANK ENTRY, IF ENTRY IS NOT AN
     alphabetical letter or if that letter has been previously entered.
     It will all entries in arrays were converted to lower case letters.
     */
    public static char readChar(String question, ArrayList<Character>allGuesses){
        boolean match= false;
        while (true){
            System.out.print(question);
            try{
                String answer = scanner.nextLine();
                for(int i=0; i< allGuesses.size(); i++){
                    if( allGuesses.get(i) == Character.toLowerCase(answer.charAt(0))) {
                        match =true;
                    }else if (allGuesses.get(i) != Character.toLowerCase(answer.charAt(0))){
                        match=false;
                    }
                }

                while(answer.isBlank() || answer.length()>1||!Character.isAlphabetic(answer.charAt(0)) || match == true) {
                    if(match == true){
                        System.out.println("You have already entered that letter! Please enter a letter you have not tried: ");
                    }else{
                        System.out.println("You must enter one character A-Z");
                    }

                    System.out.println(question);
                    answer = scanner.nextLine();

//                while(match == true){
//                    System.out.println("You have already entered that letter! Please enter a letter you have not tried: ");
//                    answer = scanner.nextLine();

                    for(int i=0; i< allGuesses.size(); i++){
                        if( allGuesses.get(i) == Character.toLowerCase(answer.charAt(0))) {
                            match =true;
                        }else if (allGuesses.get(i) != Character.toLowerCase(answer.charAt(0))){
                            match=false;
                        }}

                }

                return Character.toLowerCase(answer.charAt(0));

            } catch (InputMismatchException e){
                System.out.println(question);
                scanner.nextLine();
                System.out.println("Entry invalid, please try again");

            }
        }

    }
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
}