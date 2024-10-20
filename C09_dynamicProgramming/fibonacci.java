package C9_dynamicProgramming;

import java.util.Scanner;

public class fibonacci {
    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int ans1 = fib(n-1);
        int ans2 = fib(n-2);
        return ans1 + ans2;
    }
    public static int fibDP(int n, int dp[]){
        if(n==0 || n==1){
            return n;
        }
        int ans1, ans2;
       if(dp[n-1]==-1){
           ans1 = fibDP(n-1,dp);
           dp[n-1] = ans1;
       }
       else{
           ans1 = dp[n-1];
       }
       if(dp[n-2]==-1){
           ans2 = fibDP(n-2,dp);
           dp[n-2] = ans2;
       }
       else{
           ans2 = dp[n-2];
       }
       return ans1 + ans2;
    }

    public static int fiBInterativeDP(int n){
        int [] dp = new int[n+1];
        //base cases are given as initial inputs to the dp[] array
        dp[0] = 0;
        dp[1] = 1;
        //now n>=2
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-2] + dp[i+2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter n: ");
        int n = s.nextInt();
        int dp[] = new int[n+1];
        //we are setting -1 in dp at all indices in main buz in recursive func,haar call pe yeh dp[] ko -1 pe kar dega
        for(int i = 0; i<dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(fibDP(n,dp));
    }
}
