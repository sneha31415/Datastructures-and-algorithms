package C3_stacks;

public class stackUse {
    public static void main(String[] args) throws stackFullException,stackEmptyException {
        stackUsingArray s = new stackUsingArray();
//        s.push(10);
//        s.push(20);
//        s.push(30);
//        System.out.println(s.top());
//        s.push(40);
      //  System.out.println(s.top());
//        System.out.println(s.isEmpty());
//        s.pop();
        int arr[] = {1,2,3,6,7};
        for(int i=0;i< arr.length;i++){
          s.push(arr[i]);
        }
        while(!s.isEmpty()){
         //   System.out.print(s.pop()+ " ");
        }
        stackUsingArray s1 = new stackUsingArray();
        s.push(20);
        s.push(30);
       System.out.println(s.pop()); //30 is removed
        System.out.println( s.top());
        s.push(90);
        s.push(70);
        s.push(80);
        System.out.println(s.top());

        while(!s.isEmpty()){
           System.out.print(s.pop()+" ");
        }
    }
}
