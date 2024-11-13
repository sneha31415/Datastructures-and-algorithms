package mockInterview;

import java.util.Arrays;

public class daysSorting {

    /*
    day12 day3
    image14 day5 day25 image 14  image12image
    if letters are not same the dont extract the digits
    Arrays.sort((a, b) -> {if (word a is not same as word b) a.compare(b)
                          else {
                          compare by numerical value}})

*/

    public static String extractWord(String word) {
        int i = 0, n = word.length();
        StringBuilder extractedWord = new StringBuilder();
        while (i < n) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                break;
            }
            extractedWord.append(word.charAt(i));
            i++;
        }
        return extractedWord.toString();
    }

    public static int extractNumber(String word) {
        String extractedWord = extractWord(word);
//        image21
        String number = word.substring(extractedWord.length());
        return Integer.parseInt(number);
    }


    public static void main(String[] args) {
        String[] input = {"day2", "image31", "day10", "day0", "windows11", "image0"};
        Arrays.sort(input, (a, b) -> {
            if (extractWord(a).equals(extractWord(b))){
                return extractNumber(a) - extractNumber(b);
            }else {
                return a.compareTo(b);
            }
        });

        System.out.println(Arrays.toString(input));
    }
}
