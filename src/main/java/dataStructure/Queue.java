package dataStructure;

import java.util.Arrays;

public class Queue {
    static final int MAX = 6;
    static int[] intArray = new int[MAX];
    static int front = 0;
    static int rear = -1;
    static int itemCount = 0;

    static int peek(){
        return intArray[front];
    }

    static boolean isEmpty(){
        return itemCount == 0;
    }

    static boolean isFull(){
        return itemCount == MAX;
    }

    static int size(){
        return itemCount;
    }

    static void insert(int data){
        if (!isFull()){
            if (rear == MAX -1){
                rear = -1;
            }
            intArray[++rear] = data;
            itemCount++;
        }
    }

    static int removeData(){
        int data = intArray[front++];
        if (front == MAX) front = 0;
        itemCount--;
        return data;
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(5);
        insert(6);
        insert(9);

        Arrays.stream(intArray).forEach(System.out::println);
    }

}
