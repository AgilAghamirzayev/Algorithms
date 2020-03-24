package sorting;

import java.util.Arrays;

public class QuickSort {

    static int partition(int[] array, int begin, int end){
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]){
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[end];
        array[end] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end){
        if (end <= begin) return;
        int pivot = partition(array,begin,end);
        quickSort(array,begin,pivot-1);
        quickSort(array, pivot+1, end);
    }

    public static void main(String[] args) {
        int[] a = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };

        quickSort(a,0,a.length-1);

        System.out.println(Arrays.toString(a));
    }
}
