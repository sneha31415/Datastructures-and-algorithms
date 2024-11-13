package C10_priorityQueue;

import java.util.ArrayList;

public class priorityQueue<T> {
    //arraylist will be private
    private ArrayList<element<T>> heap;
    public priorityQueue(){
        //now we have given a reference to the arraylist "heap" and created an empty arraylist
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority){
        element<T> e = new element<>(value, priority);
        heap.add(e);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;
        while(childIndex > 0){   //if childIndex = 0 then root has been reached
            if(heap.get(parentIndex).priority > heap.get(childIndex).priority){
                //SWAPPING
                element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else{
                return;
            }
        }
    }

    public T removeMin() throws priorityQueueEmptyException{
        if(heap.isEmpty()){
            throw new priorityQueueEmptyException();
        }

        element <T> removed = heap.get(0);
        T ans = removed.value;
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int parentIndex = 0;
        int leftchildIndex = (2*parentIndex) + 1;
        int rightchildIndex = (2*parentIndex) + 2;

        //part 2 swapping
        //finding the minimum most priority wla index amongst the three
        while(leftchildIndex < heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(leftchildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftchildIndex;
            }
            if (rightchildIndex < heap.size() && (heap.get(rightchildIndex).priority < heap.get(minIndex).priority)) {
                minIndex = rightchildIndex;
            }
            //if none of the above two "ifs" is executed that means the parentIndex is the suited position and no swapping is needed so break from the further steps below
//            if(minIndex == parentIndex){
//                break;
//            }
                if(minIndex == parentIndex){
                    break;
                }
                element<T> temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(minIndex));
                heap.set(minIndex, temp);

                parentIndex = minIndex;
                leftchildIndex = (2 * parentIndex) + 1;
                rightchildIndex = (2 * parentIndex) + 2;

        }
        return ans;
        }


    public T getMin() throws priorityQueueEmptyException{
        if(isEmpty()){
            throw new priorityQueueEmptyException();
        }
        return heap.get(0).value;
    }

    public int size(){
    //heap is an arraylist so we can just use inbuilt .size() method of arraylist and so do not need to maintain a variable size
    return heap.size();
    }

    public boolean isEmpty(){
    return heap.size() == 0;
    }
}
