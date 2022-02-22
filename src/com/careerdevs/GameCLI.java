package com.careerdevs;

import com.careerdevs.ui.UserInput;

import java.util.ArrayList;
import java.util.Random;

public class GameCLI {
    public static String[] playableWords;
    public static ArrayList randomWordArray;
    public static ArrayList guessedWord;


    public static void main(String[] args) {
//        mainMenu();

        wordInitializer();
        wordSize();




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
    private static void wordSize(){
       String randomWord = randomlySelectedWord();
       int randomWordSize = randomWord.length();
        System.out.println("word size: " +randomWordSize);
        System.out.println("random word selected: "+randomWord);
        randomWordArray = new ArrayList<>();
        for(int i = 0; i < randomWordSize; i++){
            randomWordArray.add('_');

        }
        System.out.println("print out");
        for(int j = 0; j < randomWordSize; j++){
            System.out.print( randomWordArray.get(j)+" ");

        }

    }
}
