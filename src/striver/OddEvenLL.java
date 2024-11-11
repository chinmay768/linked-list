package striver;

import java.util.*;

public class OddEvenLL {

    public static Node oddEvenNaive(Node head){
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();

        Node temp = head;
        while (temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null){
            list.add(temp.data);
        }

        temp = head.next;
        while (temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null){
            list.add(temp.data);
        }

        int curr = 0;
        temp = head;
        while (temp != null){
            temp.data = list.get(curr);
            temp = temp.next;
            curr++;
        }

        return head;
    }

    public static Node oddEven(Node head){
        if(head == null) return null;

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        Node head = LinkedList.convertArrayToLL(arr);

        head = oddEven(head);

        LinkedList.printLL(head);
    }
}
