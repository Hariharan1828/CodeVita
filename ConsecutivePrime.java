import java.util.Scanner;

public class ConsecutivePrime {
    static Boolean algo(int n){
        int sum=2;
        for(int i =3;i<n;i++){
            if(isPrime(i)){
                sum+=i;
            }
            if(sum==n) return true;

        }



        return false;

    }
    static boolean isPrime(int b){
        int j,cnt;
        cnt=1;
        for (j = 2; j <= b/2; j++) {
            if(b%j==0)
                cnt=0;
        }
        if(cnt==0)return true;
        else
            return false ;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt=0;
        for (int i =5;i<=n;i++){
            if(algo(i)){
                cnt++;
            }

        }
        System.out.print(cnt);
    }

}