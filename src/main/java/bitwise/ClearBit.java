package bitwise;

public class ClearBit {
    public static void main(String[] args) {
        System.out.println(clearBit(72, 8));
        System.out.println(clearBit(1,2));
        System.out.println(flipBit(0b01100110,0b00000010));
        System.out.println(flipBit(1,2));
        System.out.println(modifyBit(0b00000110,0b00000101,0b00000001));
        System.out.println(modifyBit(0b00000110,0b00000010,0b00000000));
        odd();
        even();
    }

    static int clearBit(int x, int position){
        int mask = 1 << position;
        return x & ~mask;
    }

    static byte flipBit(int x, int position){
        int mask = 1 << position;
        return (byte) (x ^ mask);
    }

    static int modifyBit(int x, int position, int state){
        int mask = 1 << position;
        return (x & ~mask) | (-state & mask);
    }

    static void odd(){
        for (int i = 1; i < 101 ; i++)
            if ( (i & 1 ) == 1)
                System.out.println(i);
    }

    static void even(){
        for (int i = 1; i < 101; i++)
            if ((i & 1) == 0)
                System.out.println(i);
    }
}
