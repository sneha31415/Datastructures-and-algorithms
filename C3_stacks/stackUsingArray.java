package C3_stacks;

public class stackUsingArray {
    private int data[]; //must be private
    private int topIndex; //buz stack is an abstract data type, so the array and the topIndex must be private so that only the developer can access all the contents of the stack

    //constructor
    public stackUsingArray() {
        data = new int[3];
        topIndex = -1;
    }

    //parameterized constructor for user defined sized stack
    public stackUsingArray(int size) {
        data = new int[size];
        topIndex = -1;
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    //tc = O(1) of all the func buz all the work is not dependent on the stack size due to the data member "topIndex"
    public void push(int elem) throws stackFullException {
        topIndex++;
        //throwing error
//        if(topIndex== data.length){
//            stackFullException e = new stackFullException();
//            throw e;
//        }
//        else{
//            data[topIndex] = elem;
//        }

        // ERROR HANDLING FOR STACK FULL EXCEPTION using dynamic array concept
        if (topIndex < data.length) {
            data[topIndex] = elem;
        } else {
            int size = topIndex;
            int temp[] = data;
            data = new int[2 * temp.length];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
            data[topIndex] = elem;
        }
    }

    public int top() throws stackEmptyException {
        if (topIndex == -1) {
            //throw stackEmpty exception
            stackEmptyException e = new stackEmptyException();
            throw e;
            //OR WE CAN JUST WRITE= "throw new stackEmptyException();"
            }
            return data[topIndex];
        }
        public int pop() throws stackEmptyException {
            //if stack is empty then we cannot pop and must throw an error
            if (topIndex == -1) {
                stackEmptyException e = new stackEmptyException();
                throw e;
            } else {
                topIndex--; //no need to explicitly delete the element that is to be poped just decrease the topIndex, and now when someone usse push(), then new element will be added replacing the poped one }
                return data[topIndex + 1];
            }

        }
    }

