
import java.util.Arrays;
import java.util.Scanner;


public class CollectingCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0;i<t;i++){
            int n = sc.nextInt();
            int[] candies = new int[n];
            for(int j =0;j<n;j++){
                candies[j]=sc.nextInt();
            }
            long minTime = calculateMinTime(candies, n);

            System.out.println(minTime);

        }

    }
    private static long calculateMinTime(int[] candies, int n) {
        Arrays.sort(candies);
        long totalTime = 0;
        for (int i = 0; i < n- 1; i++) {
            int combinedCandies = candies[i] + candies[i + 1];
            totalTime += combinedCandies;

            candies[i + 1] = combinedCandies;

            Arrays.sort(candies);
        }

        return totalTime;


    }

}