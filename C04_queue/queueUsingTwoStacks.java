package C4_queue;

import java.util.Stack;

public class queueUsingTwoStacks<T> {
     Stack <T> s1;
     Stack <T> s2;
     int size;
     public queueUsingTwoStacks(){
         s1 = new Stack<>();
         s2 = new Stack<>();
         size =0;
     }
     public int size(){
     return size;
     }
     public boolean isEmpty(){
         return size==0;
     }
     public T dequeue() throws QueueEmptyException{
         if(s1.size()==0){
             QueueEmptyException e = new QueueEmptyException();
             throw e;
         }
         while(s1.size()!=1){
             s2.push(s1.pop());
         }
         T temp1= s1.pop(); //since we poped so, the last elem is deleted
         while(!s2.isEmpty()){
             T temp2 = s2.pop();
             s1.push(temp2);
         }
         size=size-1;
         return temp1;
     }
     public void enqueue(T elem){
         s1.push(elem);
         size++;
     }
     public T front(){
         while(size!=1){
             T temp = s1.pop();
             s2.push(temp);
         }
         T temp1 = s1.peek();
         while(!s2.isEmpty()){
             T temp2 = s2.pop();
             s2.push(temp2);
         }
         return temp1;
     }
}
