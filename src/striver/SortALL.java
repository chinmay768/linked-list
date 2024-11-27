package striver;
import java.util.*;

public class SortALL {

    public static Node sortLLNaive(Node head){
        List<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null){
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = head;
        int i = 0;
        while (temp != null){
            temp.data = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }

    public static Node findMidNode(Node head){
        Node slow = head;
        Node fast = head.next; // Modification to find firt mid elm in even no. of nodes

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeTwoSortedLists(Node head1, Node head2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;

        return dummyNode.next;
    }

    public static Node sortLLUsingMergeSort(Node head){
        if(head == null || head.next == null) return head;

        Node mid = findMidNode(head);

        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        leftHead = sortLLUsingMergeSort(leftHead);
        rightHead = sortLLUsingMergeSort(rightHead);

        return mergeTwoSortedLists(leftHead, rightHead);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5, 6};

        Node head = LinkedList.convertArrayToLL(arr);
        head = sortLLUsingMergeSort(head);

        LinkedList.printLL(head);
    }
}
