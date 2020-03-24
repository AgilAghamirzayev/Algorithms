package bitwise;

public class Remainder9 {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if ((i & 0b1) == 0 ){
                System.out.println(i);
            }
        }
    }
}
