package programming.challenegs.kata;

import java.util.*;
import java.math.BigInteger;


/*
Description:

We have the following sequence:

f(0) = 0
f(1) = 1
f(2) = 1
f(3) = 2
f(4) = 4;
f(n) = f(n-1) + f(n-2) + f(n-3) + f(n-4) + f(n-5);

Your task is to give the number of total values for the odd terms of the sequence up to the n-th term (included). (The number n (of n-th term) will be given as a positive integer)

The values 1 (one) is the only that is duplicated in the sequence and should be counted only once.

E.g.
count_odd_pentaFib(5) -----> 1 # because the terms up to 5 are: 0, 1, 1, 2, 4, 8 (only 1 is odd and counted once)

Other examples:
count_odd_pentaFib(10) ------> 3 #because the odds terms are: [1, 1, 31, 61] (three different values)
count_odd_pentaFib(15) ------> 5 # beacause the odd terms are: [1, 1, 31, 61, 1793, 3525] (five different values)
 */

public class Pentabonacci {
    public static long countOddPentaFib(long n) {
        Set<BigInteger> oddFibonacci = new HashSet<>();
        List<BigInteger> lastFive = new ArrayList<>();
        BigInteger fibonacciNumber;

        for(int i=0;i<=n;i++){
            if(i==0)
                fibonacciNumber= new BigInteger("0");
            else if(i<3)
                fibonacciNumber= new BigInteger("1");
            else{
                fibonacciNumber = new BigInteger("0");
                for(BigInteger bi:lastFive)
                    fibonacciNumber=fibonacciNumber.add(bi);
            }

            if(lastFive.size()==5){
                lastFive.remove(0);
                lastFive.add(fibonacciNumber);
            }
            else
                lastFive.add(fibonacciNumber);

            BigInteger[] divideRemainder = fibonacciNumber.divideAndRemainder(new BigInteger("2"));

            if(divideRemainder[1].equals(new BigInteger("1"))){

                oddFibonacci.add(fibonacciNumber);
            }
        }
        return oddFibonacci.size();
    }
}
