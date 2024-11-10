package striver;

import java.util.Stack;

public class ReverseDLL {

    public static DNode reverseDLLNaive(DNode head){
        if (head == null) return null;

        Stack<Integer> stack = new Stack<>();
        DNode temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }

        return head;
    }

    public static DNode reverseDLL(DNode head){
        if(head == null || head.next == null) return head;

        DNode current = head;
        DNode prev = null;
        while (current != null){
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;

            current = current.prev;
        }

        return prev.prev;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        DNode head = DoublyLinkedList.convertArrToDLL(arr);
//        head = reverseDLLNaive(head);
        head = reverseDLL(head);
        DoublyLinkedList.printDLL(head);
    }
}
