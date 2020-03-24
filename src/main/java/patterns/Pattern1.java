package patterns;

public class Pattern1 {
    public static void main(String[] args) {

        int s = 12;
        int k;
        for (int i = 1; i <= s; i++) {
            k = (i%2!=0) ? i+1:i;
            for (int j = 0; j < k; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
