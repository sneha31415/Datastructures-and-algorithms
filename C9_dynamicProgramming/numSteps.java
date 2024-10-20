package C9_dynamicProgramming;

import java.util.Scanner;

public class numSteps {
    //recursive approach
    public static int numsteps(int n){
        if(n== 0 ){
            return 1;
        }
        if(n==1 || n==2){
            return n;
        }
        return numsteps(n-1) + numsteps(n-2) + numsteps(n-3);
    }

    //recursive approach with storing to avoid the repetitive calls
    public static int numStepsDP(int n, int [] dp){
        //initialise dp[n+1] with -1 in the main()
        if(n==0){
            return 1;
        }
        if(n==1 || n==2){
            return n;
        }
        int ans1, ans2, ans3;
        if(dp[n-1]==-1){
            ans1 = numStepsDP(n-1, dp);
            dp[n-1] = ans1;
        }else{
         ans1 = dp[n-1];
        }
        if(dp[n-2]==-1){
            ans2 = numStepsDP(n-2, dp);
            dp[n-2] = ans2;
        }else{
            ans2 = dp[n-2];
        }
        if(dp[n-3] == -1){
            ans3 = numStepsDP(n-3, dp);
            dp[n-3] = ans3;
        }
        else{
            ans3 = dp[n-3];
        }
        return ans1 + ans2 + ans3;
    }
    public static int numStepsIterative(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n: ");
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(numStepsIterative(n));
    }
}
