package GFG.Stack;

import java.util.ArrayList;
import java.util.List;

public class StackImplementation {
    private static class MyStackArray {
        private int top = -1;
        private int[] arr;

        MyStackArray(int c) {
            arr = new int[c];
        }

        void push(int i) {
            arr[++top] = i;
        }

        int pop() {
            return arr[top--];
        }

        int peek() {
            return arr[top];
        }

        int size() {
            return top + 1;
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    private static class MyStackArrayList {
        List<Integer> list = new ArrayList<>();

        void push(int i) {
            list.add(i);
        }

        int pop() {
            int res = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return res;
        }

        int peek() {
            return list.get(list.size() - 1);
        }

        int size() {
            return list.size();
        }

        boolean isEmpty() {
            return list.isEmpty();
        }
    }

    private static class MyStackLinkedList {
        private static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        Node head;
        int size;

        MyStackLinkedList() {
            head = null;
            size = 0;
        }

        void push(int i) {
            Node temp = new Node(i);
            temp.next = head;
            head = temp;
            size++;
        }

        int pop() {
            int res = head.data;
            head = head.next;
            size--;
            return res;
        }

        int peek() {
            return head.data;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return head == null;
        }

    }

    public static void main(String[] args) {
//        MyStackArray myStack = new MyStackArray(5);
//        MyStackArrayList myStack = new MyStackArrayList();
        MyStackLinkedList myStack = new MyStackLinkedList();
        //Problems
//        System.out.println(myStack.pop());
//        System.out.println(myStack.peek());

        myStack.push(10);
        myStack.push(20);
        System.out.println(myStack.pop());
        myStack.push(30);
        System.out.println(myStack.size());
    }
}
