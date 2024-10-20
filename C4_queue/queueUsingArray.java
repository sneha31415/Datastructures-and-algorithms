package C4_queue;

public class queueUsingArray extends QueueEmptyException {
    private int data[];
    private int front; //front maintains the index of the frontmost element
    private int rear; //rear maintains the index of the current last element
    private int size;
    public queueUsingArray(){
        data = new int[5];
        front = -1; //when there is one element, then {front index, rear index} = {0,0}
        rear = -1;
        //no need to initialize size as 0 as bydefault it is set to zero
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(int n){
        if(size== data.length) { //OR THROW A "QUEUE FULL EXCEPTION"
           doubleCapacity();
        }
        if (size == 0) {
            front=0;  //in this case, front will be updated
        }
//        rear++;
//           if(rear== data.length){
//                rear =0;    //CIRCULAR QUEUE
//            }
             rear = (rear+1)% data.length;  //oneliner for above 3 lines

            data[rear] = n;
            size++;
    }
    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2*temp.length];
        int index =0;
        for(int i=front;i< temp.length;i++){
            data[index++] = temp[i];
        }
        for(int i=0;i<front-1;i++){  //and  not i<rear
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length-1;
    }
        public int dequeue() throws QueueEmptyException{
        //dequeue i.e removal is always from the start i.e the 0th index of the array
            if(size==0){
                throw new QueueEmptyException();
            }
            int temp=data[front];

//             front++;
//            if(front== data.length){
//            front=0;
//        }
            front = (front+1)% data.length;
            size--;

            if(size==0){
                rear=-1;
                front=-1; //buz then size of the queue becomes 0 so, the rear and front must be -1
            }
            return temp;
        }

        public int showFront() throws QueueEmptyException{
        if (size==0){
            throw new QueueEmptyException();
        }
        else{
            return data[front];
        }
        }




}
