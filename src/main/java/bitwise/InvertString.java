package bitwise;

public class InvertString {
    public static void main(String[] args) {
        InvertString is = new InvertString();
        System.out.println(is.invert("aBC"));
        System.out.println(is.invert("abC"));
        System.out.println(is.invert("ABC"));

        System.out.println(is.toUppercase("aqil"));
        System.out.println(is.toLowercase("AQIL"));
    }


    String invert(String origin){
        char[] chars = origin.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            int bit = 0b100000;
            chars[i] = (char)(chars[i] ^ bit);
        }
        return new String(chars);
    }

    String toUppercase(String origin){
        char[] chars = origin.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            int bit = 0b00100000;
            int mask = ~bit;
            chars[i] = (char)(chars[i] & mask);
        }
        return new String(chars);
    }


    String toLowercase(String origin){
        char[] chars = origin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int bit = 0b00100000;
            chars[i] = (char)(chars[i] | bit);
        }
        return new String(chars);
    }

}