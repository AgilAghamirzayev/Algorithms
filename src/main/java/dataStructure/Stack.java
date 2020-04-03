package dataStructure;

public class Stack {
    static int MAX = 10;
    static int[] stack = new int[8];
    static int top = -1;

    static boolean isEmpty(){
        return top == -1;
    }

    static boolean isFull(){
        return top == MAX;
    }

    static int peek(){
        return stack[top];
    }

    static int pop(){
        int data;
        if(!isEmpty()){
            data = stack[top];
            top = top - 1;
            return data;
        } else {
            System.out.println("Could not retrieve data, Stack is empty");
            return 0;
        }
    }

    static void push(int data) {
        if (!isFull()) {
            top = top + 1;
            stack[top] = data;
        } else
            System.out.println("Could not insert data, Stack is full");
    }

    public static void main(String[] args) {
        push(2);
        push(3);
        push(5);
        push(6);
        push(9);
        push(11);

        System.out.println(peek());
        while (!isEmpty()){
            System.out.println(pop());
        }

        System.out.println("Stack is full: " + isFull());
        System.out.println("Stack is empty: " + isEmpty());
    }
}