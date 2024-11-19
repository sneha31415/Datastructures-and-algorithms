package C9_dynamicProgramming;

public class length_of_minimum_subsequence {
    public static int LCS(String s1, String s2, int p1, int p2){
        //p1 and p2 are pointers to iterate over s1 and s
        if(p1 == s1.length() || p2 == s2.length()){
            return 0;
        }
        int myAns ;
            if (s1.charAt(p1)==s2.charAt(p2)){
                int smallAns =  LCS(s1, s2, p1+1, p2+1);
                myAns = 1 + smallAns;
            }else {
                int ans1, ans2;
                ans1 = LCS(s1, s2, p1+1, p2);
                ans2 = LCS(s1, s2, p1, p2+1);
                myAns = Math.max(ans1, ans2);
            }
        return myAns;
    }
    public static int LCSRecursiveDP(String s1, String s2, int p1, int p2, int[][]dp){
        if(p1 == s1.length() || p2 == s2.length()){
            return 0;
        }
        int myAns ;
        if(s1.charAt(p1) == s2.charAt(p2)){
            int smallAns;
            if(dp[p1 + 1][p2 + 1] == -1){
                smallAns = LCSRecursiveDP(s1, s2, p1+1, p2+1, dp);
                dp[p1 + 1][p2 + 1] = smallAns;
            }
            else{
                smallAns = dp[p1 + 1][p2 + 1];
            }
            myAns = smallAns +1;
        }
        else{
            int ans1, ans2;
            if(dp[p1 +1][p2] == -1){
                ans1 = LCSRecursiveDP(s1, s2, p1 + 1, p2, dp);
                dp[p1 + 1][p2] = ans1;
            }
            else{
                ans1 = dp[p1 + 1][p2];
            }
            if(dp[p1][p2 + 1] == -1){
                ans2 = LCSRecursiveDP(s1, s2, p1, p2 + 1, dp);
                dp[p1][p2 + 1] = ans2;
            }
            else{
                ans2 = dp[p1][p2 + 1];
            }
            myAns = Math.max(ans1, ans2);
        }
        return myAns;
    }

    public static int LCSIterative(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];

//        for(int i = 0; i<dp.length; i++){
//            for(int j =0; j<dp[0].length; j++){
//                dp[i][j]  = 0;
//            }
//        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                //NO NEED TO HANDLE BASE CASE SEPARATELY CUZ IT IS HANDLED IN THE BELOW LINES
//                if(s1.charAt(m-1) == s2.charAt(n-1)){
//                    dp[m-1][n-1] = 1;
//                }else{
//                    dp[m-1][n-1] = 0;
//                }

                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s1 = "abcdgec";
        String s2 = "bfdmgjc";
        System.out.println(LCS(s1,s2,0,0));
//        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
//        for(int i =0; i< dp.length; i++){
//            for(int j =0; j<dp[0].length; j++){
//                dp[i][j] = -1;
//            }
//        }
//        System.out.println(LCSRecursiveDP(s1,s2,0,0,dp));
        System.out.println(LCSIterative(s1,s2));
    }
}
