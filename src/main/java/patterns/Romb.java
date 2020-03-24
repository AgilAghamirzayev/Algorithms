package patterns;

public class Romb {
    public static void main(String[] args) {

        int s = 5;


        for (int i = 0; i < s ; i++) {
            for (int j = s-1; j > i; j--)
                System.out.print(" ");
            for (int j = s; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }

    }
}
