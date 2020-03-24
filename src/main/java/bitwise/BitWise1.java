package bitwise;

public class BitWise1 {
    public static void main(String[] args) {
        int x = 9;
        if (x % 2 != 0) { }
        int remainder1 = x & 1;
        int remainder2 = x % 2;

      //  System.out.println(remainder1);
      //  System.out.println(remainder2);

        int remainder3 = x % 4;
        int remainder4 = x & 0b11;
      //  System.out.println(remainder3);
      //  System.out.println(remainder4);

        int remainder5 = x % 5;
        int remainder6 = x ^ 0b1101;

        int q = 0b10101010;
        int high_PART = q & 0b11110000;
     //   System.out.println(q);
     //   System.out.println(high_PART);
     //   System.out.println(remainder5);
     //   System.out.println(remainder6);
     //   System.out.println(0b1001);


        int a = 100;
        System.out.println(a>>1);
        System.out.println(a>>2);
        System.out.println(a>>3);

        System.out.println(a<<1);
        System.out.println(a<<2);
        System.out.println(a<<3);
    }
}
