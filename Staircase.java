

import java.util.*;

public class Staircase {
    static int calc(int n){




        if(n<=1) return n;
        return calc(n-1)*calc(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int ans = calc(n);
    }

}