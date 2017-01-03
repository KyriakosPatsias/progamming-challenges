package programming.challenegs.kata;

import java.util.*;


/*
 Description:
 Given an array, find the int that appears an odd number of times.
 There will always be only one integer that appears an odd number of times.
 */


public class FindOdd {
    public static int findIt(int[] A) {

        List<Integer> oddCounts = new LinkedList<>();

        // if number is in the list and it is seen again =>
        // even occurrences so far
        for(Integer element:A){
            if(!oddCounts.contains(element)){
                oddCounts.add(element);
            }
            else{
                oddCounts.remove(element);
            }
        }
        return oddCounts.get(0);
    }
}
