package C3_stacks;
import java.util.Stack;

public class balanced_paranthesis_problem {
    public static boolean balanced_paranthesis(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (s.isEmpty()) {
                    return false;
                }
            }
            char ch = st.peek();
            st.pop();
            if (s.charAt(i) == ')' && ch == '(') {

            } else if (s.charAt(i) == ']' && ch == '[') {

            } else if (s.charAt(i) == '}' && ch == '{') {

            } else {
                return false;
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        String s = "(a+b)";
        boolean b =  balanced_paranthesis(s);
        System.out.println(b);
    }
}
