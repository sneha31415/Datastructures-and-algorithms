package C22_someLessons;
import java.util.*;

// Learning : whenever in a tree based structure, one possible solution is bfs other than recursion

public class A1_bfs_vs_recursion {
//    problem : given an integer "n", generate all the possible binary strings of length n
    public static void generateBinaryStringsRecursive(int n, List<String> binaryStrs, StringBuilder binary) {
        if (binary.length() == n) {
            binaryStrs.add(new String(binary));
            return;
        }
        binary.append("0");
        generateBinaryStringsRecursive(n, binaryStrs, binary);
        binary.deleteCharAt(binary.length() - 1);
        binary.append("1");
        generateBinaryStringsRecursive(n, binaryStrs, binary);
        binary.deleteCharAt(binary.length() - 1);
    }

//    VV IMP approach 2 : bfs on tree
//    the binary tree can be  traversed is bfs way, finally the leaf nodes will give us the answer
    public static List<String> generateBinaryStringsBFS(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (int binarystrlen = 0; binarystrlen < n; binarystrlen++) {
            int levelSize = queue.size();
            for (int levelNode = 0; levelNode < levelSize; levelNode++) {
                String binary = queue.poll();
//               two options : append '0' or append '1'
                queue.add(binary + '0');
                queue.add(binary + '1');
            }
        }
        List<String> binaryStrs = new ArrayList<>();
        while (!queue.isEmpty()) {
            binaryStrs.add(queue.poll());
        }
        return binaryStrs;
    }

//    approach 3 : n length string can generate 0 to 2^n-1 valued binary numbers
//    eg n = 2 -> gives 0, 1, 2, 3 , convert to binary -> 00, 01, 10, 11
//    note : here we need to pass n when we are converting decimal to binary so that string is pf that length

    public static void main(String[] args) {
        List<String> binaryStrs = new ArrayList<>();
        int n = 2;
        generateBinaryStringsRecursive(n, binaryStrs, new StringBuilder());
        System.out.println(binaryStrs);
        List<String> binarystrsDFS = generateBinaryStringsBFS(n);
        System.out.println(binarystrsDFS);
    }
}
