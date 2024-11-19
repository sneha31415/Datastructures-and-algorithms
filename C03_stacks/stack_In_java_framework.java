package C3_stacks;
import java.util.Stack;
public class stack_In_java_framework {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek()); //here peek() is same as top()
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());


        int arr[] = {1,2,3,4,5};
        Stack<Integer> s = new Stack<>();
        for(int i=0;i< arr.length;i++){
            s.push(arr[i]);
        }
        //by enhanced for loop we travel over the entries and not the iterations
       /* for(int elem : arr){
            s.push(elem);
        } */
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}
