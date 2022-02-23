package com.careerdevs;

import com.careerdevs.ui.UserInput;

import java.util.ArrayList;
import java.util.Random;

public class GameCLI {
    public static String[] playableWords;
    public static ArrayList randomWordArray;
    public static ArrayList guessedWordArray;
    private static ArrayList wrongGuessesArray;
    public static int randomWordSize;
    private static String randomWord;
    private static int guessesLeft;


    public static void main(String[] args) {
//        mainMenu();

        wordInitializer();
        wordSetUp();





    }


    public static void mainMenu(){
        System.out.println("1) StartGame \n2) Exit Game ");
        int userSelection = UserInput.ReadInt("select an option", 1,2);
        switch (userSelection){
            case 1 -> System.out.println("option one");
            case 2 -> System.out.println("option 2");
        }
    }

    public static void wordInitializer(){
        playableWords = new String[] {
                "about", "beginning", "carry",
                "dance", "early", "false",
                "glasses", "happy", "issues",
                "jewels", "knife", "labor",
                "major", "never", "oceans",
                "paint", "quick", "radar",
                "seize", "taste", "under",
                "value", "wages"

        };

    }
    private static String randomlySelectedWord(){
        //get playable words length
        int arrayLength = playableWords.length;
        System.out.println("list size: "+ arrayLength);
        // randomly select a number that's between 0 and array length (-1) .
        Random rand= new Random();
        int randomlyGeneratedNum = rand.nextInt(arrayLength);
        System.out.println("random number: " + randomlyGeneratedNum);

        return playableWords[randomlyGeneratedNum];
    }
    private static void wordSetUp(){
       randomWord = randomlySelectedWord();
        randomWordSize = randomWord.length();
        System.out.println("word size: " +randomWordSize);
        System.out.println("random word selected: "+randomWord);
        randomWordArray = new ArrayList<>();
        guessedWordArray = new ArrayList<>();


        // this will print out empty _______
        for(int j = 0; j < randomWordSize; j++){
            // add all random word characters into an array
            randomWordArray.add(randomWord.charAt(j));
            // how does randomWord add all _ before printing out?
            // add _ and print out  empty _______
            guessedWordArray .add('_');
            System.out.print( guessedWordArray .get(j)+" ");

        }
        System.out.println("\n");
        wrongGuessesArray = new ArrayList<>();
        guessesLeft = 7;
        while(guessesLeft>0){
            userGuessedCharacter();
            guessesLeft--;

        }

    }
    private static void userGuessedCharacter(){


        char guessedLetter = UserInput.readChar("Please enter your Guess: ");
        char upperCaseguessedLetter = Character.toUpperCase(guessedLetter);
//        wrongGuessesArray = new ArrayList<>();
        wrongGuessesArray.add(upperCaseguessedLetter);

        for(int j = 0; j < randomWordSize; j++){

            System.out.println(upperCaseguessedLetter+ "     letter entered");
            System.out.println(Character.toUpperCase(randomWord.charAt(j))+"   letter in comp");


            // Print what current
            if(upperCaseguessedLetter == Character.toUpperCase(randomWord.charAt(j))) {
                guessedWordArray.set(j, randomWord.charAt(j));

            }





        }

        // this prints out ------- with correct letters
        for(int i = 0; i<randomWordSize; i++){
            System.out.print( guessedWordArray.get(i)+" ");
        }


        System.out.println("\n"+ wrongGuessesArray.size()+"wrong guess array size");

        // this prints out all the guesses array

        for(int k = 0; k < wrongGuessesArray.size(); k++){

            System.out.print( wrongGuessesArray.get(k)+" ,");
        }
        System.out.println("\n");

    }
}
