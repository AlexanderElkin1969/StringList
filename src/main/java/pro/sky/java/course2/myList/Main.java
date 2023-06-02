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

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("1. sortBubble");
        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("2. sortSelection");
        start = System.currentTimeMillis();
        sortSelection(arr1);
        System.out.println(System.currentTimeMillis() - start);

        arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println("2. sortInsertion");
        start = System.currentTimeMillis();
        sortInsertion(arr1);
        System.out.println(System.currentTimeMillis() - start);

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

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

}
