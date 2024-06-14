// notes from in class
// INDEX: 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
// VALUE: XX 02 03 XX 05 XX 07 XX 09 XX 11 XX 13 XX 15 XX 17 XX 19 XX 21 XX 23 XX 25
// in my program set to 0, here itll be XX
//  we know 3 is not a multiple of 2
// ex: 6 is 3 spaces to the right of 3,
// ask user for number input
// find all prime numbers up to that number

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
// this was a tricky one. i had to look up the sieve of eratosthenes and goldbach's conjecture to learn a little more

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number to find prime numbers up to (min 2): ");
        int num = scanner.nextInt();

        // doesnt work for 0 or 1
        if (num < 2) {
            System.out.println("Min # allowed is 2.");
            return;
        }

        // num + 1 to account for 0 index
        int[] array = new int[num + 1];

        sieve(array);

        System.out.println("Sieve of Eratosthenes for 2 to " + num + ": ");
        for (int i = 1; i <= num; i++) {
            // if val at index i is not 0 print it
            if (array[i] != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.println("Goldbach's Conjecture: ");
        goldbach(array);

        scanner.close();
    }

    // sieve of eratosthenes
    // for loop. if statement. if 0 skip it. if not 0, actually go through the array and knock out the multiples of that number
    // sqrt. if. else.
    public static void sieve(int[] array) {
        // - 1 to account for 0 index
        int nums = array.length - 1;

        // init array and assume all prime
        for (int i = 1; i <= nums; i++) {
            array[i] = i;
        }

        // set 2nd index to 0
        array[1] = 0;

        // i^2 <= nums
        // i <= sqrt(nums)
        for (int i = 2; i * i <= nums; i++) {
            if (array[i] != 0) {
                for (int key = i * i; key <= nums; key += i) {
                    array[key] = 0;
                }
            }
        }
    }

    // goldbach's conjecture
    // for loop to go from 4 to <= n ex. 1 million
    // search the array for the first candidate prime value
    public static void goldbach(int[] array) {
        int nums = array.length - 1;

        // target evens +=2
        for (int start = 4; start <= nums; start += 2) {
            // iterate through arr to check if diff is prime
            for (int i = 2; i <= nums; i++) {
                if (array[i] != 0 && array[start - i] != 0) {
                    System.out.println(start + " = " + (start - i) + " + " + i);
                    // out of bounds error
                    break;
                }
            }
        }
    }
}
