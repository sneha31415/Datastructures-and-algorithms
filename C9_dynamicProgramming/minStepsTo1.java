package C9_dynamicProgramming;

import java.util.Scanner;

public class minStepsTo1 {
    //GREEDY APPROACH FAILS FOR CASES LIKE (n=10)
    /*public static int minsteps(int n){
        if(n==2 || n==3){
            return 1;
        }
        if(n==5){
          return n-1;
        }
        int count = 0;
        while(n>1) {
            if (n % 3 == 0) {
                minsteps(n / 3);
                n /= 3;
                count++;
            } else if (n % 2 == 0) {
                minsteps(n / 2);
                n /= 2;
                count++;
            } else {
                minsteps(n - 1);
                n -= 1;
                count++;
            }
        }
        return count;
    } */

    public static int minsteps(int n){
        if(n == 1){
            return 0;
        }
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        if(n % 2 == 0){
            ans1 = minsteps(n/2);
        }
        if(n % 3 == 0){
            ans2 = minsteps(n/3);
        }

        //this path is always possible
        int ans3 = minsteps(n-1);
         //now we have explored all the possible paths, now just get the shortest possible path
            return Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }

    public static int minstepsDP(int n, int[] dp){
        if(n == 1){
            return 0;
        }
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int ans3;
        if(n % 2 ==0){
            if(dp[n/2] == -1){
                //this means we dont have the ans and need to make a call
                ans1 = minstepsDP(n/2,dp);
                dp[n/2] = ans1;
            }else{
                ans1 = dp[n/2];
            }
        }

        //we will calculate ans2 only if n%3==0, so we need to give ans2 some default value(initialise with "Integer.MAX_VALUE")
        if(n % 3 == 0){
            if(dp[n/3] == -1){
                ans2 = minstepsDP(n/3, dp);
                dp[n/3] = ans2;
            }else{
                ans2 = dp[n/3];
            }
        }
        if(dp[n-1]==-1){
            ans3 = minstepsDP(n-1,dp);
            dp[n-1] = ans3;
        }else{
            ans3 = dp[n-1];
        }
        return Math.min(ans1,Math.min(ans2,ans3)) + 1;
    }

    public static int minstepsIterativeDP(int n){
        int dp [] =new int[n+1]; //of size is n+1 then only indexing goes from 0.... n
        //dp[0] = -1;
        dp[1] = 0;
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        for(int i=2; i<=n; i++){
            if(i%2 == 0){
               ans1 = dp[i/2];
            }if(i%3 == 0){
               ans2 = dp[i/3];
            }
            int ans3 = dp[i-1];
            dp[i] = 1 + Math.min(ans1, Math.min(ans2, ans3)) ;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter n: ");
        int n = s.nextInt();
        int dp[] = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(minstepsDP(n, dp));
        System.out.println(minstepsIterativeDP(n));
    }
}
