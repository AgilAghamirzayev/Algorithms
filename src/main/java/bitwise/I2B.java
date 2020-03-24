package bitwise;

public class I2B {
    public static void main(String[] args) {
        i2b1(12);
        i2b2(12);
        i2b3(12);
        i2b3(-33);
       // i2b4(12);
    }

    public static void i2b1(int a){
        StringBuilder binary = new StringBuilder();
        while (a>0){
            int b = a % 2;
            binary.append(b);
            a=a/2;
        }
        System.out.println(binary.reverse().toString());
    }

    public static void i2b2(int a){
        StringBuilder binary = new StringBuilder();
        while (a>0){
            int b = a & 0b1;
            binary.append(b);
            a = a >> 1;
        }
        System.out.println(binary.reverse().toString());
    }

    public static void i2b3(int b){
        StringBuilder binary = new StringBuilder();
        for (int i = 7; i >= 0 ; i--) {
            int part = b >> i;
            int bit = part & 0b1;
            binary.append(bit);
        }
        System.out.println(binary.toString());
    }

//    public static void i2b4(int b){
//        StringBuilder binary = new StringBuilder();
//        IntStream.rangeClosed(0,7).unordered().forEach(s->{
//            int part = b >> s;
//            int bit = part & 0b1;
//            binary.append(bit);
//        });
//        System.out.println(binary.toString());
//    }


}
