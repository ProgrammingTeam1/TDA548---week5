package assignments.product;

import java.util.Random;

import static java.lang.Character.isLetter;
import static java.lang.System.out;

/*
 * This represents the secret word to guess
 */
public class Secret {

    // MUST use this as a representation (because lab is a bit about Stings)
    private final String answer;  // The word to guess
    private String mask= "";  // Masking the answer, initially one underscore for each char in answer.
    private static Random rand= new Random();

    Secret(String[] alternatives){
        answer=alternatives[rand.nextInt(alternatives.length)];

        for(int i=0; i<answer.length(); i++){
            if(!isLetter(answer.charAt(i))){
                mask += answer.charAt(i)+" ";
            }else {
                mask += "_ ";
            }
        }

    }



    // TODO
}
