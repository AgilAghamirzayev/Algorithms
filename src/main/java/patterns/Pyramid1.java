package patterns;

public class Pyramid1 {
    public static void main(String[] args) {

        int p_height = 5;
        int p_space = p_height -1;
        int x = 1;

        // pyramid on top
        for (int i = 0; i <= p_height ; i++) {
            for (int j = 0; j < p_height; j++)
                System.out.print(" ");
            for (int j = p_space; j >= i; j--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        //bottom pyramids
        for (int i = 0; i < p_height; i++) {
            for (int j = p_space; j > i; j--)
                System.out.print(" ");
            for (int j = 0; j <= i ; j++)
                System.out.print("* ");
            for (int j =(p_height + p_height -2); j >= x ; j--)
                System.out.print(" ");
            for (int k = 0; k <= i ; k++)
                System.out.print("* ");
            x += 2;
            System.out.println();
        }

    }
}
