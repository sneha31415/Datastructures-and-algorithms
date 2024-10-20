package WE;

public class usingArray {
    public static int word_frequency(String inputString, int n) {
        int ans = 0;
        String[] words = inputString.split("[ ,.]");
        for(int i=0;i<words.length;i++){
            System.out.print("{"+words[i]+"}"+" ");
        }
        String temp[]=new String[words.length];
        int tempcount =-1;
        for(int i=0;i<temp.length;i++){

        }
        for (int i = 0; i < words.length; i++) {
            int count = 1;
            temp[++tempcount]=words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].equals(words[i])) {
                    count++;
                }
            }
            if (count == n) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String Q = "hello demo, demo,navy demo five five";
        int ans =word_frequency(Q,2);
        System.out.println(ans);

    }
}


