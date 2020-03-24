package taks;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortApp {
  // big O notation
  // O(1)       - fastest
  // O(log N)
  // O(N)
  // O(N * log N)
  // O(N^2)
  // O(N^2 / 2)
  // O(N^N)     - slowest
  // O(N!)

  static void sort(int[] data) {
    for (int i = 0; i < data.length; i++) {
      for (int j = i; j < data.length; j++) {
        if (data[i] > data[j]) {
          int t = data[i];
          data[i] = data[j];
          data[j] = t;
        }
      }
    }
  }


  public static void main(String[] args) {
    String s = Integer.toString(15);
    int[] data = new Random().ints(1, 30).limit(20).toArray();
    System.out.println(Arrays.toString(data));
    sort(data);
    System.out.println(Arrays.toString(data));
  }
}
