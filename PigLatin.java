package assignments.basics;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

/*
 * This program translates from English to Pig latin
 * See,https://en.wikipedia.org/wiki/Pig_Latin
 */
public class PigLatin {

    public static void main(String[] args) {
        new PigLatin().program();
    }

    private final Scanner scan = new Scanner(in);

    private void program() {

        // Only for english
        out.println(toPigLatin("My name is Eric").equals("yMay amenay isway Ericway"));
        out.println(toPigLatin("Eric").equals("Ericway"));
        out.println(toPigLatin("name").equals("amenay"));

        // Kill with Ctrl + c or let IntelliJ do it
        while (true) {
            String line = scan.nextLine();
            out.println(toPigLatin(line));
        }

    }

    // Write method toPigLatin (use functional decomposition!)
    public String toPigLatin(String s){
        String[] words = toWords(s);
        String returnString = "";
        for (int i = 0; i < words.length; i++){
            if (consonantLowerSound(words[i].toLowerCase().charAt(0))){
                returnString +=  shiftLeft(words[i]) + "ay";
            }
            else{
                returnString += words[i] + "way";
            }

            if (i != words.length - 1){
                returnString += " ";
            }
        }
        return returnString;
    }
    private String[] toWords(String sentence){
        return sentence.split(" ");
    }
    private  String shiftLeft(String s){
       return s.substring(1) + s.charAt(0);
    }
    private boolean consonantLowerSound(char c){
        switch (c){
            case 'a':case 'e':case 'i':case 'o':case 'u':case 'y': return false;
            default: return true;
        }
    }


}
