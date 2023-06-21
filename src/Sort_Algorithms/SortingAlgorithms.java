package Sort_Algorithms;

import java.util.Arrays;

public class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int smallest;
        for (int i = 0; i < arr.length - 1; i++) {
            smallest = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[smallest])
                    smallest = j;

            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int insert, moveItem;
        for (int i = 1; i < arr.length; ++i) {
            insert = arr[i];
            moveItem = i;

            while (moveItem > 0 && arr[moveItem-1] > insert) {
                arr[moveItem] = arr[moveItem-1];
                moveItem--;
            }
            arr[moveItem] = insert;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            //Recursion
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Test class
    public static void main(String[] args) {
        int[] arr = {61, -16, 25, 143, 104, -35, 108, 82, 17, 55, 75, 100, 10, 91, 128, 39, -40, 149, -12,
                14, 63, 34, -11, 16, 120, 52, -46, -64, 101, 130, 1, -8, 23, 67, 154, 158, 113, 19, 109,
                138, 46, 78, 43, 87, 57, 141, 114, 31, 129, -32, -3, -55, 166, 76, 161, 84, 92, 85, 7, 88,
                36, 86, 4, 105, 68, 5, 41, 94};
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        System.out.println("Original array: " + Arrays.toString(arr)+ "\n");

        System.out.println("Array before bubblesort: " + Arrays.toString(arrCopy));
        long startTime = System.nanoTime();
        bubbleSort(arrCopy);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Bubble Sorted array: " + Arrays.toString(arrCopy));
        System.out.println("Bubble Sort Execution Time: " + duration + " ns\n"); // -84600 ns- in my computer

        arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before selectionSort: " + Arrays.toString(arrCopy));
        startTime = System.nanoTime();
        selectionSort(arrCopy);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Selection Sorted array: " + Arrays.toString(arrCopy));
        System.out.println("Selection Sort Execution Time: " + duration + " ns\n"); // -47400 ns- in my computer


        arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before insertionSort: " + Arrays.toString(arrCopy));
        startTime = System.nanoTime();
        insertionSort(arrCopy);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Insertion Sorted array: " + Arrays.toString(arrCopy));
        System.out.println("Insertion Sort Execution Time: " + duration + " ns\n"); // -32100 ns- in my computer


        arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before quickSort: " + Arrays.toString(arrCopy));
        startTime = System.nanoTime();
        quickSort(arrCopy, 0, arrCopy.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sorted array: " + Arrays.toString(arrCopy));
        System.out.println("Quick Sort Execution Time: " + duration + " ns\n"); // -19300 ns- in my computer

        arrCopy = Arrays.copyOf(arr, arr.length);
        System.out.println("Array before mergeSort: " + Arrays.toString(arrCopy));
        startTime = System.nanoTime();
        mergeSort(arrCopy, 0, arrCopy.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Merge Sorted array: " + Arrays.toString(arrCopy));
        System.out.println("Merge Sort Execution Time: " + duration + " ns"); // -41300 ns- in my computer
    }
}
