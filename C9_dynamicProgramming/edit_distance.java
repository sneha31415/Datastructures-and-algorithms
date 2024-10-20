package C9_dynamicProgramming;

public class edit_distance {
    public static int edit_distance(String s1, String s2, int p1, int p2){
        int m = s1.length();
        int n = s2.length();

         //base case
        // if one of the string becomes empty, then the "length of the REMAINING substring" is the ans
       if(p1 == m){
           return s2.substring(p2).length();
       }
       if(p2 == n){
           return s1.substring(p1).length();
       }

        int myAns;
        if(s1.charAt(p1) == s2.charAt(p2)){
           myAns = edit_distance(s1, s2, p1+1, p2+1);
        }else{
            int ans1, ans2, ans3;
            ans1 = 1 + edit_distance(s1, s2, p1 + 1, p2 + 1);
            ans2 = 1 + edit_distance(s1, s2, p1 + 1, p2);
            ans3 = 1 + edit_distance(s1, s2, p1, p2 + 1);
            myAns = Math.min(ans1, Math.min(ans2, ans3));
        }
        return myAns;
    }

    //this can be done without pointers by shortening the string s1 , s2 itself
    public static int edit_distance_dp(String s1, String s2, int m, int n, int dp[][]){ //m and n are pointers p1 and p2
   //again and again this is getting inilialised to zero so this is wrong
//    int m = 0;
//    int n = 0;

    if(m == s1.length()){
        return s2.length() - n;
    }
    if(n == s2.length()){
        return s1.length() - m;
    }

    int myAns ;
    if(s1.charAt(m) == s2.charAt(n)) {
        if (dp[m+1][n+1] == -1) {
            myAns = edit_distance_dp(s1, s2, m+1, n+1, dp);
            dp[m+1][n+1] = myAns;
        }else{
           myAns = dp[m+1][n+1];
        }
    }else{
        int substitute, delete, insert;
        if(dp[m+1][n+1] == -1){
            substitute = 1 + edit_distance_dp(s1, s2, m+1, n+1, dp);
            dp[m+1][n+1] = substitute;
        }else{
            substitute = dp[m+1][n+1];
        }
        if(dp[m+1][n] == -1){
            delete = 1 + edit_distance_dp(s1, s2, m+1, n, dp);
            dp[m+1][n] = delete;
        }else{
            delete = dp[m+1][n];
        }
        if(dp[m][n+1] == -1){
            insert = 1 + edit_distance_dp(s1, s2, m, n+1, dp);
            dp[m][n+1] = substitute;
        }else{
            insert = dp[m][n+1];
        }
        myAns = Math.min(substitute,Math.min(delete,insert));
    }
    return myAns;
    }

    public static int edit_distance_iterative(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i = 0; i<dp[0].length; i++){
            dp[0][i] = i;
        }
        for(int j = 0; j<dp.length; j++){
            dp[j][0] = j;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1 ; j < n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){ //since string indexing starts from 0, we did i-1
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abcgghgufutd";
        System.out.println(edit_distance(s1, s2, 0, 0));
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i =0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(edit_distance_dp(s1, s2, 0, 0, dp));
        System.out.println(edit_distance_iterative(s1, s2));
    }
}
