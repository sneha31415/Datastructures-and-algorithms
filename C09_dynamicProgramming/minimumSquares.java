package C9_dynamicProgramming;

public class minimumSquares {
    public static int minSquares(int n){
        int minSquare = Integer.MAX_VALUE;
        if(n==0){
            return 0;
        }
//        if(n==1 || n==2 || n==3){
//            return n;
//        }
        for(int i = 1; i*i <= n; i++){
            int smallAns = minSquares(n-i*i);
            if (smallAns<minSquare){
                minSquare = smallAns;
            }
        }
        return minSquare+1;
    }

    //memoization or recursive dp
    public static int minSquaresDP(int n, int[]dp){
        if(n == 0){
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            int currAns;
            //if you have the ans use it, else call it ans store it
            if(dp[n-(i*i)] == -1){
                currAns = minSquaresDP(n-(i*i), dp);
                dp[n-(i*i)] = currAns; //store the ans;
            }else{
             currAns = dp[n-(i*i)];
            }
            if(currAns<minAns){
                minAns = currAns;
            }
        }
        return minAns+1;
    }

    public static int minSquaresIterative(int n){
        int [] dp  = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i<=n; i++){
            int minSquare = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){ //solve
                int currans = dp[i-(j*j)];
                if(currans < minSquare){
                    minSquare = currans;
                }
            }
            dp[i] = minSquare + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n+1];
        for(int i = 0; i<dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(minSquaresDP(n,dp));
        System.out.println(minSquaresIterative(n));
    }
}
