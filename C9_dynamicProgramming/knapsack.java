package C9_dynamicProgramming;

public class knapsack {
    public static int knapsack(int w, int wt[], int val[], int i){
        if(i == wt.length){
            return 0;
        }
        int myAns ;
        if(wt[i] > w){  //THIS CONDITION MEANS THAT YOU ARE NOT ALLOWED TO INCLUDE THE ith ITEM
            myAns = knapsack(w, wt, val, i+1);
        }
        else{
            int includeItem, excludeItem;
            //including the ith item
            includeItem = val[i] + knapsack(w-wt[i], wt, val, i+1);
            //excluding the ith item even if its allowed
            excludeItem = knapsack(w, wt, val, i+1);
            myAns = Math.max(includeItem, excludeItem);
        }
        return myAns;
    }

    public static int knapsackRecursiveDP(int w, int []wt, int[]val, int i, int dp[][]){
        //if wt[] array is empty or i has crossed wt array, then max value = 0;
        if(i == wt.length){
            return 0;
        }
        int myAns;
        if(wt[i] > w){
            if(dp[w][i+1] == 0){
                myAns = knapsackRecursiveDP(w,wt,val,i+1,dp);
                dp[w][i+1] = myAns;
            }else{
                myAns = dp[w][i+1];
            }
        }else{
            int excludeItem, includeItem;
            if(dp[w][i+1] == 0){
                excludeItem = knapsackRecursiveDP(w, wt, val,i+1, dp);
                dp[w][i+1] = excludeItem;
            }else{
                excludeItem = dp[w][i+1];
            }
            if(dp[w-wt[i]][i+1] == 0){
                includeItem = val[i] + knapsackRecursiveDP(w-wt[i], wt, val, i+1, dp);
                dp[w-wt[i]][i+1] = includeItem;
            }else{
                includeItem = val[i] + dp[w-wt[i]][i+1];
            }
            myAns = Math.max(excludeItem, includeItem);
        }
        return myAns;
    }

    public static int knapsackIterative(int w, int wt[], int val[]){
        int n = wt.length;
        int dp[][] = new int[n+1][w+1];
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= w; j++){
                if(wt[i] > j){
                    dp[i][j] = dp[i+1][j];
                }else{
                    int includeItem = val[i] + dp[i+1][j-wt[i]];
                    int excludeItem = dp[i+1][j];
                    dp[i][j] = Math.max(includeItem, excludeItem);
                }
            }
        }
        return dp[0][w]; // GADHO JAISE dp[0][0] mat return karna cuz then it will give the ans for max_weight = 0
    }

    public static void main(String[] args) {
        int [] wt  = {20, 25, 30};
        int [] val = {200, 100, 100};
        int w = 50;
        System.out.println(knapsack(w, wt, val, 0));
        int dp[][] = new int[w+1][wt.length+1];
        System.out.println(knapsackRecursiveDP(w, wt, val, 0, dp));
        System.out.println(knapsackIterative(w, wt, val));
    }
}
