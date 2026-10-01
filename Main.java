 /***Due date: Friday, 2 October 2026, 5:00 AM
 Maximum number of files: 1
Type of work:  Individual work
Implement Heap Sort using a Max Heap. Build the heap, repeatedly move the maximum element to the end of the unsorted region, reduce the heap size, and heapify.

Required Methods
·        buildMaxHeap(int[] arr)

·        heapify(int[] arr, int n, int i)

·        heapSort(int[] arr)***/
class HeapSort {

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        buildMaxHeap(arr);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }
}

class Main{
    public static void main(String[] args) {

        int[] arr = {89,10,90,98,12,23};
        
        HeapSort h1 = new HeapSort();
        
        h1.heapSort(arr);

        System.out.println("Sorted Array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}