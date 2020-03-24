package sorting;

import java.util.Arrays;

public class InsertionSorting {
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i-1;
            while ( j>=0 && current<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 5, 6, 9, 4, 2, 3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}