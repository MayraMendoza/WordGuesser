package com.careerdevs;

import com.careerdevs.ui.UserInput;

import java.util.ArrayList;
import java.util.Random;

public class GameCLI {
    public static String[] playableWords;
    public static ArrayList randomWord;
    public static ArrayList guessedWord;

    public static void main(String[] args) {
//        mainMenu();

        wordInitializer();
        System.out.println(randomlySelectedWord());




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
        int arrayLength = playableWords.length;
        System.out.println(arrayLength);
        // randomly select a number that's between 0 and array length (-1) .
        Random rand= new Random();
        int int_Random = rand.nextInt(arrayLength);
        System.out.println(int_Random);
       String word = playableWords[int_Random];
        return word;
    }
}
