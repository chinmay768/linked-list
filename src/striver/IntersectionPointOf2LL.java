package striver;

import java.util.HashSet;
import java.util.Optional;

public class IntersectionPointOf2LL {

    public static Optional<Node> findIntersectionNaive(Node head1, Node head2){
        HashSet<Node> visitedNodes = new HashSet<>();

        Node temp = head1;
        while (temp != null){
            visitedNodes.add(temp);
            temp = temp.next;
        }

        temp = head2;
        while (temp != null){
            if(visitedNodes.contains(temp)) return Optional.of(temp);

            temp = temp.next;
        }

        return Optional.empty();
    }

    public static Node findCommonNode(Node head1, Node head2, int dist) {
        while (dist != 0){
            head1 = head1.next;
            dist--;
        }

        while (head1 != null || head2 != null){
            if(head1 == head2) return head1;

            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

    public static Node findIntersectionNaive2(Node head1, Node head2){
        if(head1 == null || head2 == null) return null;

        int len1 = 0, len2 = 0;
        Node temp1 = head1, temp2 = head2;

        while (temp1 != null){
            len1++;
            temp1 = temp1.next;
        }

        while (temp2 != null){
            len2++;
            temp2 = temp2.next;
        }

        Node intersection = null;
        if(len1 > len2)
            intersection = findCommonNode(head1, head2, len1 - len2);
        else
            intersection = findCommonNode(head2, head1, len2 - len1);

        return intersection;
    }

    public static Node findIntersection(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1; // This condition takes care of both the cases 1. Intersection present 2. Intersection Not Present

            if(temp1 == null) temp1 = head2;
            if(temp2 == null) temp2 = head1;
        }

        return temp1;
    }

    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        // creation of second list
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        head2.next.next.next = head1.next.next;

//        Optional<Node> intersection = findIntersectionNaive(head1, head2);
//        intersection.ifPresent(node -> System.out.println(node.data));

        Node intersection = findIntersection(head1, head2);
        if(intersection != null)
            System.out.println(intersection.data);

//        if(intersection.isPresent()){
//            System.out.println(intersection.get());
//        }
    }
}
