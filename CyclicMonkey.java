// N monkeys are invited to a party where they start dancing. They dance in a circular formation, very similar to a Gujarati Garba or a Drum Circle. The dance requires the monkeys to constantly change positions after every 1 second.

// The change of position is not random & you, in the audience, observe a pattern. Monkeys are very disciplined & follow a specific pattern while dancing.

// Consider N = 6, and an array monkeys = {3,6,5,4,1,2}.

// This array (1-indexed) is the dancing pattern. The value at monkeys[i], indicates the new of position of the monkey who is standing at the ith position.

// Given N & the array monkeys[ ], find the time after which all monkeys are in the initial positions for the 1st time.

// Constraints

// 1<=t<=10 (test cases)
// 1<=N<=10000 (Number of monkeys)

// Input Format

// First line contains single integer t, denoting the number of test cases.
// Each test case is as follows –
// Integer N denoting the number of monkeys.
// Next line contains N integer denoting the dancing pattern array, monkeys[].

// Output

// t lines,
// Each line must contain a single integer T, where T is the minimum number of seconds after which all the monkeys are in their initial position.



// Test Case

// Explanation

// Example 1

// Input

// 1
// 6
// 3 6 5 4 1 2

// Output

// 6

import java.util.Scanner;

public class CyclicMonkey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] monkeys = new int[n];

            for (int i = 0; i < n; i++) {
                monkeys[i] = sc.nextInt();
            }

            int time = findDanceTime(n, monkeys);
            System.out.println(time);
        }
        sc.close();
    }

    private static int findDanceTime(int n, int[] monkeys) {
        int[] initialPositions = new int[n];

        for (int i = 0; i < n; i++) {
            initialPositions[i] = i + 1;
        }

        int time = 0;

        while (!isArrayEqual(monkeys, initialPositions)) {
            time++;
            for (int i = 0; i < n; i++) {
                int temp = monkeys[i];
                monkeys[i] = monkeys[temp - 1];
                monkeys[temp - 1] = temp;
            }
        }

        return time;
    }

    private static boolean isArrayEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}