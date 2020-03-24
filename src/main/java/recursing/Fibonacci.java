package recursing;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.println(i+ ": "+fib(i));
        }
    }

    static int fib(int n){

        int[] f = new int[]{};

        for (int a: f) {
            if (a==f[n])
                return f[n];
        }

        if (n==1) return 1;
        if (n==2) return 1;
        int value = fib(n-1)+fib(n-2);
        f[n] = value;
        return value;

    }
}
