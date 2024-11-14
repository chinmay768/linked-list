package striver;

import java.util.List;
import java.util.Stack;

public class ReverseLL {

    public static Node reverseLL(Node head) {
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;

        while (curr != null){
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node reverseLLRec(Node head) {
        if(head == null || head.next == null) return head;

        Node revHead = reverseLLRec(head.next);

        Node next = head.next;
        next.next = head;
        head.next = null;

        return revHead;
    }

    public static Node reverseLLNaive(Node head){
        Stack<Integer> stack = new Stack<>();

        Node temp = head;
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = LinkedList.convertArrayToLL(arr);

        head = reverseLL(head);

        LinkedList.printLL(head);
    }
}
