package search;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class BinarySearch {
    static int[] data = new Random().ints(0, 10000).limit(1000).toArray();
    static int[] sorted = data.clone();

    // count number of `if` statements
    // executed to find the given element
    // we need to return `boolean` and `index` and `count`
    static int find_conventional(int[] origin, int number) {
        int counter = 0;
        for (int el: origin) {
            counter++;
            if (el == number) break;
        }
        return counter;
    }

    // count number of `if` statements
    // executed to find the given element
    // we need to return `boolean` and `index` and `count`

    static class Result {
        public final Optional<Integer> index;
        public final int count;

        Result(Optional<Integer> index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    static Result find_binary(int[] origin, int number) {
        int counter = 0;
        int l = 0;
        int r = origin.length - 1;
        while (l < r) {
            counter++;
            int m = (l + r) / 2;
            if (number == origin[m]) return new Result(Optional.of(m), counter);
            if (number > origin[m]) l = m + 1;
            else r = m - 1;
        }
        return new Result(Optional.empty(), counter);
    }

    // recursive function
    static Result find_binaryR(int[] origin, int number, int l, int r) {
        int counter = 0;
        int m = (l + r) / 2;
        counter++;
        if (l>r) return new Result(Optional.of(m),counter);
        if (number == origin[m]) return new Result(Optional.of(m),counter);
        else if (number > origin[m]) return find_binaryR(origin, number, l , r + 1);
        else return find_binaryR(origin,number,l - 1,r);
    }

    // runner function
    static Result find_binaryR(int[] origin, int number) {
        return find_binaryR(origin, number, 0, origin.length-1);
    }

    public static void main(String[] args) {
        Arrays.sort(sorted);
//    System.out.println(Arrays.toString(data));
//    System.out.println(Arrays.toString(sorted));
//    int rnd_idx = 249+500; // it means index == m on particular iteration
        int rnd_idx = (int) (Math.random()*1000);
        int rnd = sorted[rnd_idx];
        int count1 = find_conventional(data, rnd);
        Result r = find_binary(sorted, rnd);
        Result count3 = find_binaryR(sorted, rnd);
//        System.out.println(count1);
//        String message = r.index.map(i -> String.format("Index: %d", i)).orElse("Not found");
//        String finalMessage = String.format("Value %d %s, iterations count:%d\n", rnd, message, r.count);
//        System.out.println(finalMessage);
        System.out.println(count3.index);
    }
}
