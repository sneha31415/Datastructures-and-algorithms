package org.example;

public class recursion03 {
    public static String[] returnSubsequences(String s) {
        //base case
        if (s.length()==0){
            String[] ans ={" "};
            return ans;
        }
        String[] smallans = returnSubsequences(s.substring(1));
        String [] ans = new String [2*smallans.length];
        for(int i=0;i<smallans.length;i++){
            ans[i] = smallans[i];
        }
        for(int i=0;i< smallans.length;i++){
            ans[i+ smallans.length]=s.charAt(0)+ans[i];
        }
        return ans;
    }

    public static String[] helper (int n){
       if(n<0 || n>10){
           System.exit(0);
       }
       if(n==2){
           String output[]={"a","b","c"};
           return output;
       }
        else if(n==3){
            String output[]={"d","e","f"};
            return output;
        }
        else if(n==4){
            String output[]={"g","h","i"};
            return output;
        }
        else {
            String output[] ={"j","k","l"};
            return output;
       }
    }
    public static String [] keypad(int n) {
       //base  case
       // i.e if number = just 0; number ke bich 0 aega toh yeh  base case use affect nahi karega eg.203

       if(n==0){
           String [] output= {" "};
           return output;
       }
       String smallArray[]= keypad(n/10);
       String[] lastDigit = helper(n%10);
       String output[]= new String[smallArray.length*lastDigit.length];
       int k =0;
       for(int i=0;i< lastDigit.length;i++){
           for(int j=0;j<smallArray.length;j++){
               output[k]=smallArray[j]+lastDigit[i];
               k++;
           }
       }
       return output;
    }
    public static void printSubsequences(String input,String output){
        //base case
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        //when the first element is not included
        printSubsequences(input.substring(1),output);
        //when the first element is included
        printSubsequences(input.substring(1),output+input.charAt(0));

    }




    public static void main(String[] args) {
//        String s = "sneha";
//        //String ans []= returnSubsequences(s);
//        int n = 23;
//        String[] ans = keypad(n);
//        for(int i =0;i<ans.length;i++){
//            System.out.println(ans[i]);
//        }
     String s = "xyz";
        printSubsequences(s," ");
    }
}