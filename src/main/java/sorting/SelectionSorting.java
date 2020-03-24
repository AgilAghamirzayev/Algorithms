package sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length ; j++) {
                if (array[j] < min){
                    min = array[j];
                    minId = j;
                }
            }
            //swapping
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 5, 6, 9, 4, 2, 3};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
