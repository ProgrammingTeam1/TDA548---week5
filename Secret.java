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

    public boolean guess(char c){

        int[] indexes = compareTo(c, answer);
        if (indexes.length == 0){
            return false;
        }
        char[] maskArr = mask.toCharArray();
        for(int i = 0; i < indexes.length; i++){
            maskArr[indexes[i]*2]= c;
        }
        mask = "";
        for (int i = 0; i < maskArr.length; i++){
            mask += maskArr[i];
        }
        return true;
    }
    public boolean hasUnderscore() {
        return !(compareTo('_', mask).length == 0);
    }

    private int[] compareTo(char c, String string){
        int counter = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == c){
                counter++;
            }
        }
        int[] returnArr = new int[counter];
        counter = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == c){
                returnArr[counter] = i;
                counter++;
            }
        }
        return returnArr;
    }

    public String toString(){
        return mask;
    }



    // TODO
}
