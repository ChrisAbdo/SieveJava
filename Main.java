// notes from in class
// INDEX: 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
// VALUE: XX 02 03 XX 05 XX 07 XX 09 XX 11 XX 13 XX 15 XX 17 XX 19 XX 21 XX 23 XX 25
// in my program set to 0, here itll be XX
//  we know 3 is not a multiple of 2
// ex: 6 is 3 spaces to the right of 3,
// ask user for number input
// find all prime numbers up to that number
// sieve of eratosthenes
// for loop. if statement. if 0 skip it. if not 0, actually go through the array and knock out the multiples of that number
// sqrt. if. else.

// goldbach's conjecture
// for loop to go from 4 to <= n ex. 1 million
// search the array for the first candidate prime value
// if statement

// example main
// do sieve
// do the for and if statement
// do goldbach
// sieve
// for ()
//  if()
//    for()
// goldbach
// for()
//   for()
//     if()
// make sure to not use multiplication, division, or modulo for finding the prime numbers

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
            "Enter the number up to which you want to find primes: "
        );
        int num = scanner.nextInt();

        // 0 and 1 not prime
        if (num < 2) {
            System.out.println("Minimum # allowed is 2.");
            return;
        }
        int[] arr = new int[num + 1];

        sieve(arr);

        System.out.println("Prime numbers up to " + num + ":");
        for (int i = 1; i <= num; i++) {
            if (arr[i] != 0) {
                System.out.print(i + " ");
            }
        }

        goldbach(arr);
        scanner.close();
    }

    public static void sieve(int[] array) {
        int n = array.length - 1;

        // init array and mark all vals as prime (for now)
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }

        // Mark non-primes as zero
        array[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (array[i] != 0) {
                for (int j = i * i; j <= n; j += i) {
                    array[j] = 0;
                }
            }
        }
    }

    public static void goldbach(int[] array) {
        int n = array.length - 1;

        for (int even = 4; even <= n; even += 2) {
            for (int i = 2; i <= n; i++) {
                if (array[i] != 0 && array[even - i] != 0) {
                    System.out.println(even + " = " + i + " + " + (even - i));
                    break;
                }
            }
        }
    }
}
