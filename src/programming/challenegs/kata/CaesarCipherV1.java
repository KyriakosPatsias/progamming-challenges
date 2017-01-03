package programming.challenegs.kata;

import java.util.*;


/*
Description:

The action of a Caesar cipher is to replace each plaintext letter with a different one a fixed number of places up or down the alphabet.

This program performs a variation of the Caesar shift. The shift increases by 1 for each character (on each iteration).

If the shift is initially 1, the first character of the message to be encoded will be shifted by 1, the second character will be shifted by 2, etc...

Coding: Parameters and return of function "movingShift"

param s: a string to be coded

param shift: an integer giving the initial shift

The function "movingShift" first codes the entire string and then returns an array of strings containing the coded string in 5 parts (five parts because, to avoid more risks, the coded message will be given to five runners, one piece for each runner).

If possible the message will be evenly split between the five runners; if not possible, parts 1, 2, 3, 4 will be longer and part 5 shorter. The fifth part can have length equal to the other ones or shorter. If there are many options of how to split, choose the option where the fifth part has the longest length, provided that the previous conditions are fulfilled. If the last part is the empty string this empty string must be shown in the resulting array.

For example, if the coded message has a length of 17 the five parts will have lengths of 4, 4, 4, 4, 1. The parts 1, 2, 3, 4 are evenly split and the last part of length 1 is shorter. If the length is 16 the parts will be of lengths 4, 4, 4, 4, 0. Parts 1, 2, 3, 4 are evenly split and the fifth runner will stay at home since his part is the empty string.

You will also implement a "demovingShift" function with two parameters

Decoding: parameters and return of function "demovingShift"

1) an array of strings: s (possibly resulting from "movingShift", with 5 strings)

2) an int shift

"demovingShift" returns a string.

Example:

u = "I should have known that you would have a perfect answer for me!!!"

movingShift(u, 1) returns :

v = ["J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!"]

(quotes added in order to see the strings and the spaces, your program won't write these quotes, see Example Test Cases)

and demovingShift(v, 1) returns u.
*/


public class CaesarCipherV1 {
    public static List<String>  movingShift(String s, int shift) {
        List<String> out = new LinkedList<>();
        StringBuilder encoded = new StringBuilder();

        for(int i = 0;i < s.length();i++){
            int newShift = shift+i;
            char curChar = s.charAt(i);
            if(Character.isLetter(curChar)){
                if(Character.isLowerCase(curChar)){
                    if((curChar+(newShift%26))<='z')
                        encoded.append((char)(curChar+(newShift%26)));
                    else
                        encoded.append((char)((curChar+(newShift%26))-26));
                }
                else{
                    if((curChar+(newShift%26))<='Z')
                        encoded.append((char)(curChar+(newShift%26)));
                    else
                        encoded.append((char)((curChar+(newShift%26))-26));
                }
            }
            else
                encoded.append(curChar);
        }

        int subMessageSize = s.length()/4;
        int subMessageSizeRemainder = s.length()%4;

        if(subMessageSizeRemainder > 0){
            // recalculate message sizes until close to even:
            while(subMessageSize>=subMessageSizeRemainder){
                subMessageSize--;
                subMessageSizeRemainder+=4;
            }
            subMessageSize++;
            subMessageSizeRemainder-=4;
        }

        for(int j=0;j<4;j++){
            out.add(encoded.substring(j*subMessageSize,(j+1)*subMessageSize));
        }

        if(subMessageSizeRemainder > 0)
            out.add(encoded.substring(4*subMessageSize,(4*subMessageSize)+subMessageSizeRemainder));
        else
            out.add("");

        return out;
    }

    public static String  demovingShift(List<String> s, int shift) {
        StringBuilder encryptedString = new StringBuilder();
        StringBuilder dencryptedString = new StringBuilder();

        for(String str:s) encryptedString.append(str);

        for(int i = 0;i < encryptedString.length();i++){
            int newShift = shift+i;
            char curChar = encryptedString.charAt(i);
            if(Character.isLetter(curChar)){
                if(Character.isLowerCase(curChar)){
                    if((curChar-(newShift%26))>='a')
                        dencryptedString.append((char)(curChar-(newShift%26)));
                    else
                        dencryptedString.append((char)((curChar - (newShift%26))+26));
                }
                else{
                    if((curChar-(newShift%26))>='A')
                        dencryptedString.append((char)(curChar-(newShift%26)));
                    else
                        dencryptedString.append((char)((curChar - (newShift%26))+26));
                }
            }
            else
                dencryptedString.append(curChar);
        }
        return dencryptedString.toString();
    }
}
