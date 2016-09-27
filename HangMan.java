package assignments.product;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The very well known Hangman game (in a text version)
 *
 *  This is the main program (program starts here)
 *
 *
 *  Recommended process
 *
 *  1. Sketch the logical skeleton using functional decomposition and abstraction
 *  (to find methods), This can be done using only comments (or pencil and paper)
 *  2. Working from both direction (top down = functional decomposition) and/or bottom up (using classes)
 *  Try to add variables and methods in classes
 *  You may try to guess (or imagine) what method could be useful for a class (if not remove them)
 *
 *  4. IMPORTANT: Contact an assistant for a talk about your ideas when you have a skeleton
 *
 *  5. Implement and test the FileService
 *  6. Implements and test one method at the time.
 *  7. Until finished
 *
 */
public class HangMan {

    private final Scanner sc = new Scanner(in);
    private final Random rand = new Random();

    public static void main(String[] args) {
        new HangMan().program();
    }

    private enum Result {
        WIN,
        LOOSE
    }


    private int nGuess = 0;
    private Result result;

    private void program() {

        String[] words = null;
        try {
            words = FileService.readFile(FileService.WORD_PATH, "words.txt");
        } catch (FileNotFoundException e) {
            out.println("Ett fel uppstod, filen med ord kunde inte hittas (eller läsas)!");
            return;
        }

        // TODO
        // Create a Man and a Secret

        Secret secret= new Secret(words);
        Man man = new Man();

        // TODO
        // The logical skeleton here

        print(man, secret);


        while (result == null){

            if (secret.guess(guessCharacter())){
                if (!secret.hasUnderscore()){
                    result = Result.WIN;
                }
            }
            else{
                man.addPart();
                if (man.isFull()){
                    result = Result.LOOSE;
                }
            }
            nGuess++;

            print(man, secret);

        }
        out.println("You "+result+"!");
        out.println("in "+nGuess+" tries");
    }

    private char guessCharacter() {
        out.println("Guess a char > ");
        return sc.nextLine().charAt(0);
    }

    private void print(Man man, Secret secret){
        out.println(man.toString());
        out.println();
        out.println(secret.toString());
        out.println();
    }

}
