package recursing;

public class Rec {

    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(factorial(1));
        System.out.println(fibonacci(101));
    }

    static int sum(int n){
        if (n == 0) return 0;
        return n + sum(n-1);
    }

    static int factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    static int fibonacci(int n){
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
