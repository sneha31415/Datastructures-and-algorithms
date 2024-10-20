package C3_stacks;

import java.util.Stack;

public class reverse_stack {
    public static void reverse(Stack< Integer> s,Stack<Integer> s1){
        //base case
        if(s.size()==1||s.size()==0){
            return ;
        }
        else{
            int top = s.pop();
            reverse(s,s1);
            while(!s.isEmpty()){
                int x = s.pop();
                s1.push(x);
            }
            s1.push(top);
        }

        while(!s1.isEmpty()){
            int x = s1.pop();
            s.push(x);
        }
    }
    public static void reverseFinal(Stack<Integer> stack){
        Stack <Integer > s1 = new Stack<>();
        Stack <Integer > s2 = new Stack<>();
    reverse( s1,  s2);
    }

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(10);
        s1.push(20);
        s1.push(5);
        reverseFinal(s1);
        while(!s1.isEmpty()){
            System.out.println( s1.pop());
        }
    }
}
