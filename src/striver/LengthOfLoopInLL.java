package striver;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoopInLL {

    public static int lengthOfLoopNaive(Node head){
        if(head == null) return 0;

        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int pos = 1;
        while (temp != null){
            if(map.containsKey(temp)){
                return pos - map.get(temp);
            }

            map.put(temp, pos);
            temp = temp.next;
            pos++;
        }
        return 0;
    }

    public static int findLen(Node slow, Node fast){
        int len = 1;
        fast = fast.next;
        while (fast != slow){
            fast = fast.next;
            len++;
        }
        return len;
    }

    public static int lengthOfLoop(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return findLen(slow, fast);
            }
        }
        return 0;
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


        int len = lengthOfLoop(head);
        System.out.println("Length of loop is: "+ len);
    }
}
