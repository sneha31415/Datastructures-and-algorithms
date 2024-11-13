package C9_dynamicProgramming;

public class minimumCostPath {
    public static int minCostPath(int[][] cost, int i, int j){
        int m = cost.length;
        int n = cost[0].length;
        //special case
        if(i == m-1  && j == n-1){
            return cost[i][j];
        }
        //base case
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }

        int path1 = minCostPath(cost,i+1, j);
        int path2 = minCostPath(cost, i, j+1);
        int path3 = minCostPath(cost, i+1, j+1);
        int minimum = Math.min(path1, Math.min(path2, path3));
        return minimum + cost[i][j];
    }

    public static int minCostPathDP(int [][] cost, int i, int j, int[][] dp){
        int m = cost.length;
        int n = cost[0].length;
        if(i == m || j == n){
            return Integer.MAX_VALUE;
        }
        if(i == m-1 && j == n-1){
            return cost[i][j];
        }
        int path1, path2, path3;
        if(dp[i+1][j] == Integer.MIN_VALUE){
            path1 = minCostPathDP(cost, i+1, j, dp);
            dp[i+1][j] = path1;
        }else{
           path1 =  dp[i+1][j] ;
        }

        if(dp[i][j+1] == Integer.MIN_VALUE){
            path2 = minCostPathDP(cost, i, j+1, dp);
            dp[i][j+1] = path2;
        }else{
           path2 =  dp[i][j+1] ;
        }

        if(dp[i+1][j+1] == Integer.MIN_VALUE){
            path3 = minCostPathDP(cost, i+1, j+1, dp);
            dp[i+1][j+1] = path3;
        }else{
           path3 =  dp[i+1][j+1];
        }
        return Math.min(path1,Math.min(path2, path3)) + cost[i][j];
    }

    public static int minCostPathIterativeBU(int [][] path){
        int row = path.length;
        int col = path[0].length;
        int dp[][] = new int[row+1][col+1];

        //initialising the dp[][] array with infinity
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = row-1; i>=0; i--){
            for(int j = col-1; j>=0; j--){
                if(j == col-1 && i == row-1){
                    dp[i][j] = path[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + path[i][j];
                }
                }
        }
        return dp[0][0];

        //SHUBHAM'S approach(ismei dp[][] aur cost[][] ke indexing mei confusion nahi hoga)..
        // in this you do not need to maintain the dp's size greater by +1

//        int[][] dp = new int[row][col];
//        for(int i=row-1; i>=0; i--){
//            for(int j=col-1; j>=0; j--){
//                if(i == row-1 && j == col-1) {
//                    dp[i][j] = path[i][j];
//                }
//                else {
//                    dp[i][j] = ( Math.min( (i+1<row ? dp[i+1][j] : Integer.MAX_VALUE), Math.min( ( (i+1<row && j+1<col) ? dp[i+1][j+1] : Integer.MAX_VALUE), (j+1 < col ? dp[i][j+1] : Integer.MAX_VALUE) ) ) ) + path[i][j];
//                }
//            }
//        }
//
//        System.out.println("----------------------------");
//        for(int i=0; i<row; i++){
//            for(int j=0; j<col; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------------");
//
//        return dp[0][0];
    }

    //top down approach
    public static int minCostIterativeTD(int path[][]){
        int m = path.length;
        int n = path[0].length;
        int dp [][] = new int[m+1][n+1];
        //initialise with infinity
        for(int i = 0 ; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < m+1; i ++){
            for(int j = 1; j < n+1; j++){
                if(i == 1 && j == 1){
                    dp[i][j] = path[0][0];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + path[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int [][] cost ={
                {1,5,11},
                {8,30,12},
                {2,35,7},
                {15,16,18}
        };
        System.out.println(minCostPath(cost,0,0));

        int dp[][] = new int[cost.length+1][cost[0].length+1];
        for(int i = 0; i< dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        System.out.println(minCostPathDP(cost, 0, 0, dp));
        System.out.println(minCostPathIterativeBU(cost));
        System.out.println(minCostIterativeTD(cost));
    }
}
