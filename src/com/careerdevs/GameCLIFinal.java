package com.careerdevs;

import com.careerdevs.ui.UserInput;
import com.careerdevs.ui.UserInputFinal;

import java.util.ArrayList;
import java.util.Random;

public class GameCLIFinal {
    private static String[] playableWords;
    private static ArrayList randomWordArray;
    private static ArrayList guessedWordArray;
    private static ArrayList allGuessesArray;
    private static int randomWordSize;
    private static String randomWord;
    private static int count;
    private static int wrongGuesses;
    private static int totalWrongGuesses;


    public static void main(String[] args) {

        wordInitializer();
        mainMenu();

    }


    public static void mainMenu() {
        System.out.println("1) StartGame \n2) Exit Game ");
        int userSelection = UserInput.ReadInt("select an option", 1, 2);
        switch (userSelection) {
            case 1 -> wordSetUp();
            case 2 -> endGame();
        }
    }

    public static void wordInitializer() {
        playableWords = new String[]{
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

    private static String randomlySelectedWord() {
        //get playable words length
        int arrayLength = playableWords.length;
//        System.out.println("list size: "+ arrayLength);

        // randomly select a number that's between 0 and array length (-1) .
        Random rand = new Random();
        int randomlyGeneratedNum = rand.nextInt(arrayLength);

//        System.out.println("random number: " + randomlyGeneratedNum);

        //return the random word that will be used in the game
        return playableWords[randomlyGeneratedNum];
    }

    private static void wordSetUp() {
        randomWord = randomlySelectedWord();
        randomWordSize = randomWord.length();
        System.out.println("Your word has " + randomWordSize + " letters. Good Luck!!");
//        System.out.println("random word selected: "+randomWord);
        // this array will hold each char of the random word selected
        randomWordArray = new ArrayList<>();

        //this array will hold _ _ _ _ _ place holders that will be replaced with
        // correct character guesses.
        guessedWordArray = new ArrayList<>();

        // this will print out empty _______
        for (int j = 0; j < randomWordSize; j++) {
            // add all random word characters into an array
            randomWordArray.add(randomWord.charAt(j));
            // how does randomWord add all _ before printing out?
            // add _ and print out  empty _______
            guessedWordArray.add('_');
            System.out.print(guessedWordArray.get(j) + " ");
        }

        System.out.println("\n");
        MainGame();
    }

    private static String MainGame() {

        // check if strings match as a secondary check.

        // this array will contain all guesses user has made.
        allGuessesArray = new ArrayList<>();
//        guessesLeft = 7;                            // count down how many guesses are left
        count = 0;                                  // count will keep track of how many blank spaces have been changed to letters
        totalWrongGuesses = 0;                      // total wrong guesses that user has made

        while (totalWrongGuesses < 7) {
            userGuessedCharacter();
            if (count == randomWordSize) {
                System.out.println("The word is: " + randomWord);
                System.out.println("Congratulations! you guessed the word with " + totalWrongGuesses + " wrong guesses.");

                // set count to 0 for next game.
                count = 0;
                mainMenu();
                return randomWord;

                // need to fix this
//                mainMenu();
            }
        }
        System.out.println("You do not have any guesses left. Thank you for playing!");
        System.out.println("The correct word is: " + randomWord);
        mainMenu();
        return randomWord;
    }

    private static void userGuessedCharacter() {

//        // print guesses left
//        System.out.println("you have " +guessesLeft +" guesses left!");

        //print total wrong guesses made / max wrong guesses allowed
        System.out.println("total wrong guesses: " + totalWrongGuesses + "/7");

        // read user input - Only accept ONE alphabetical character, no blacks, no numbers & no repeat letters.
        char guessedLetter = UserInputFinal.readChar("Please enter your Guess: ", allGuessesArray);
        char lowerCaseguessedLetter = Character.toLowerCase(guessedLetter);
        wrongGuesses = 0;

        // store all guesses in array.
        allGuessesArray.add(lowerCaseguessedLetter);


        // check if any input letter matches letter from random word array
        for (int j = 0; j < randomWordSize; j++) {

//            System.out.println(lowerCaseguessedLetter+ "     letter entered");
//            System.out.println(Character.toLowerCase(randomWord.charAt(j))+"   letter in comp");

            // replace all letters that matched to random word array (at the corresponding spot).
            if (lowerCaseguessedLetter == Character.toLowerCase(randomWord.charAt(j))) {
                // count how many placeholders are being replaced with letters.
                count++;
                guessedWordArray.set(j, randomWord.charAt(j));
            } else {
                // count how many letters did not match
                wrongGuesses++;
            }
        }

        // if there were no matches (between input letter and letter in random word) add 1 to total wrong guesses.
        if (wrongGuesses == randomWordSize) {
            totalWrongGuesses++;
        }

        // print out guessed word array  ------- with correct letters
        for (int i = 0; i < randomWordSize; i++) {
            System.out.print(guessedWordArray.get(i) + " ");
        }

        // print out all letters that were guessed by user.
        System.out.println("\n");

        for (int k = 0; k < allGuessesArray.size(); k++) {

            System.out.print(allGuessesArray.get(k) + " ,");
        }
        System.out.println("\n");
    }

    private static void endGame() {
        System.out.println("Thank you for playing!");

    }
}
