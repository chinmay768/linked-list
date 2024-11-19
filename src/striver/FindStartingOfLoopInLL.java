package striver;

import java.util.HashSet;
import java.util.Set;

public class FindStartingOfLoopInLL {

    public static Node findStaringPointNaive(Node head){
        if(head == null) return null;

        Set<Node> set = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if(set.contains(temp)){
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }

    public static Node findStartingPoint(Node head){
        if(head == null) return null;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                //We are writing this login inside this if so that we could return null if not a cycle
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
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
        head.next.next.next.next.next.next.next.next =  head.next.next.next;

        Node startPoint = findStartingPoint(head);

        if(startPoint != null)
            System.out.println(startPoint.data);
    }
}
