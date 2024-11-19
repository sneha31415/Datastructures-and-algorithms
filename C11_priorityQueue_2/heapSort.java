package C11_priorityQueue_2;

public class heapSort {

    public static void downHeapify(int arr[], int i, int n){
        int parentIndex = i;
        int LchildIndex = (2*parentIndex) + 1;
        int RchildIndex = (2*parentIndex) + 2;
        while(LchildIndex< n){
            int minIndex =  parentIndex;
            if(arr[LchildIndex] < arr[minIndex]){
                minIndex = LchildIndex;
            }
            if (RchildIndex<n && arr[RchildIndex] < arr[minIndex]) {
                minIndex = RchildIndex;
            }
            if(minIndex == parentIndex){
                return;
            }
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[minIndex];
                arr[minIndex] = temp;
                parentIndex = minIndex;
                LchildIndex = 2*parentIndex + 1;
                RchildIndex = 2*parentIndex + 2;
        }
    }
    public static void heapSort(int [] arr){
        int n = arr.length;
        int firstNonLeaf = (n/2) - 1;
        //PART 1 = BUILDING HEAP( O(n)) inside the array itself and by upheapyfying only the non- leaf nodes
        for(int i = firstNonLeaf; i>=0; i--){
            downHeapify(arr, i, n);
            //  KYA GALTI HAI????????
//            int parentIndex = i;
//            int LchildIndex = (2*parentIndex) + 1;
//            int RchildIndex = (2*parentIndex) + 2;
//
//            while(LchildIndex < n) {
//                int minIndex = parentIndex;
//                if (arr[minIndex] > arr[LchildIndex]) {
//                    minIndex = LchildIndex;
//                }
//                if (RchildIndex<n && arr[minIndex] > arr[RchildIndex]) {
//                    minIndex = RchildIndex;
//                }
//                if (minIndex == parentIndex) {
//                    break;
//                } else {
//                    int temp = arr[minIndex];
//                    arr[minIndex] = arr[parentIndex];
//                    arr[parentIndex] = temp;
//                }
//                parentIndex = minIndex;
//                LchildIndex = (2 * parentIndex) + 1;
//                RchildIndex = (2 * parentIndex) + 2;
//            }
        }

        //PART 2 - REMOVING
        for(int i = n-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            downHeapify(arr, 0, i);
//            int parentIndex = arr[0];
//            int LchildIndex = 2*parentIndex + 1;
//            int RchildIndex = 2*parentIndex + 2;
//
//            while(LchildIndex<i){
//                int minIndex = parentIndex;
//                if (arr[minIndex] > arr[LchildIndex]) {
//                    minIndex = LchildIndex;
//                }
//                if (RchildIndex< i && arr[minIndex] > arr[RchildIndex]) {
//                    minIndex = RchildIndex;
//                }
//                if (minIndex == parentIndex) {
//                    return;
//                } else {
//                    int temp2 = arr[minIndex];
//                    arr[minIndex] = arr[parentIndex];
//                    arr[parentIndex] = temp2;
//                }
//                parentIndex = minIndex;
//                LchildIndex = 2 * parentIndex + 1;
//                RchildIndex = 2 * parentIndex + 2;
//            }

        }

    }

    public static void main(String[] args) {
        //int arr[] = {35,7,1,2,0,3,4};
        int [] arr = {1,2,3,6,2,3,4,7,8};
        heapSort(arr);
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
