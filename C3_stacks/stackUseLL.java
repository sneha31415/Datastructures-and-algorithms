package C3_stacks;

import C2_linkedList.Node;

public class stackUseLL {
    public static void main(String[] args) throws stackEmptyException{
        stackUsingLL <Integer>s1= new stackUsingLL<>();
        s1.push(20);
        s1.push(30);
        s1.push(40);
         while(!s1.isEmpty()){
            System.out.println(s1.pop());
        }
         s1.top();
//       int ans = (int) s1.top();
   //     System.out.println(ans);
    }
}
