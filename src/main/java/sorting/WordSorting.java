package sorting;

import java.util.Arrays;

public class WordSorting {
    // Function to print the sorted array of string
    static void printArraystring(String str[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(str[i] + " ");
    }

    // Driver function
    public static void main(String args[]) {
        String[] s = {"azerbaijan", "z", "from", "fm"};

        Arrays.sort(s);

        System.out.println(Arrays.toString(s));
    }
}
