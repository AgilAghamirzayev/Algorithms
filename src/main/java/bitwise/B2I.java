package bitwise;

public class B2I {
    public static void main(String[] args) {
        System.out.println(b2i(111));
        System.out.println(b2i(1010));
        System.out.println(b2i(100001));

        System.out.println(b2si("10101001"));
        System.out.println(b2si("111"));
        System.out.println(b2si("000000"));
        System.out.println(b2si("100001"));
        System.out.println(Integer.parseInt("1001",2));

        System.out.println(b2ts2( "00010010"));
        System.out.println(b2ts3("00010010"));
    }

    public static int b2i(int a){
        int b=0,c=0,i=1;
        while (a>0){
            b=a%10;
            c += b*i;
            i*=2;
            a=a/10;
        }
        return c;
    }

    public static int b2si(String a){
        String num = a;
        int b = 0;
        int i = 1;
        int len = a.length();

        for (int j = len-1; j >= 0 ; j--) {
            if (num.charAt(j)=='1')
                b += i;
            i *= 2;
        }
        return b;
    }

    public static int b2ts2(String a){
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
           if (a.charAt(i)=='1') {
               int delta = (int) Math.pow(2, a.length()-i-1);
               result += delta;
           }
        }
        return result;
    }

    public static  int b2ts3(String a){
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            int digit = ch - '0';
            int delta = digit << (a.length()-i-1);
            result += delta;
        }
        return result;
    }
}
