package striver;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycleInLL {

    public static Boolean checkCycle(Node head) {
        if(head == null) return false;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }


    public static Boolean checkCycleNaive(Node head){
        Set<Node> set = new HashSet<>();

        Node temp = head;
        while (temp != null){
            if(set.contains(temp)) return true;
            set.add(temp);
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = head.next.next.next;


        Boolean isCyclePresent = checkCycle(head);
        System.out.println(isCyclePresent);
    }
}
