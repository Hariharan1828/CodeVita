import java.util.Arrays;
import java.util.Scanner;

public class RailwayStation1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arrival[] = new int[n];
        int departure[]= new int[n];
        for(int i=0;i<n;i++){
            arrival[i] = sc.nextInt();
            departure[i] = sc.nextInt();
            departure[i] = arrival[i]+departure[i];

        }
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i=0,  j=1, platform=1;
        while(i<n && j<n){
            if(arrival[i]<=departure[j]){
                platform++;
                i--;
            } else if (arrival[i]>departure[j]) {

                platform--;
                j++;
            }

        }
        System.out.println(platform);

    }



}
