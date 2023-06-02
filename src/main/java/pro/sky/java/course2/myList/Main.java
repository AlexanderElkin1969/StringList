package pro.sky.java.course2.myList;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            arr[i] = random.nextInt(100_000);
        }

        int[] arr1;
        int[] arr2;

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("1. sortBubble");
        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);
        arr2 = Arrays.copyOf(arr1,10);
        System.out.println(Arrays.toString(arr2));

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("2. sortSelection");
        start = System.currentTimeMillis();
        sortSelection(arr1);
        System.out.println(System.currentTimeMillis() - start);
        arr2 = Arrays.copyOf(arr1,10);
        System.out.println(Arrays.toString(arr2));

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("3. sortInsertion");
        start = System.currentTimeMillis();
        sortInsertion(arr1);
        System.out.println(System.currentTimeMillis() - start);
        arr2 = Arrays.copyOf(arr1,10);
        System.out.println(Arrays.toString(arr2));

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("4. quickSort");
        start = System.currentTimeMillis();
        quickSort(arr1,0, 99_999);
        System.out.println(System.currentTimeMillis() - start);
        arr2 = Arrays.copyOf(arr1,10);
        System.out.println(Arrays.toString(arr2));

    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

}
