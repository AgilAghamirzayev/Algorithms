package bitwise;

public class Task {
    public static void main(String[] args) {
        System.out.println(toUpper("AaA"));
        System.out.println(toLower("a"));

    }

//    static String invert(String orgin){
//        for (int i = 0; i <orgin.length() ; i++) {
//            return orgin.charAt(i)  orgin.charAt(i);
//        }
//    }

    static String toUpper(String orgin){
        char[] chars = orgin.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            chars[i] = (char) (chars[i] | 0b100000);
        }
        return new String(chars);
    }

    static String toLower(String orgin){
        char[] chars = orgin.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            chars[i] = (char) (chars[i] & ~0b100000);
        }
        return new String(chars);
    }
}
