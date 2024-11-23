package striver;

import java.util.*;

public class MergeTwoSortedLL {

    public static Node mergeTwoSortedLL(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node newNode = new Node(-1, null);
        Node newTemp = newNode;
        while (temp1 != null && temp2 != null){
            if(temp1.data < temp2.data){
                newTemp.next = temp1;
                temp1 = temp1.next;
            }else{
                newTemp.next = temp2;
                temp2 = temp2.next;
            }

            newTemp = newTemp.next;
        }

        if(temp1 != null) newTemp.next = temp1;
        if(temp2 != null) newTemp.next = temp2;

        return newNode.next;
    }

    public static Node mergeTwoSortedLLNaive(Node head1, Node head2){
        List<Integer> list = new ArrayList<>();
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null){
            list.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null){
            list.add(temp2.data);
            temp2 = temp2.next;
        }

        Collections.sort(list);

        int[] arr = list.stream().mapToInt(i->i).toArray();
        Node sortedLL = LinkedList.convertArrayToLL(arr);

        return sortedLL;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 3, 4, 12, 13};

        int[] arr2 = {2, 3, 6, 7, 10, 11, 13};

        Node head1 = LinkedList.convertArrayToLL(arr1);
        Node head2 = LinkedList.convertArrayToLL(arr2);

        Node sortedLL = mergeTwoSortedLL(head1, head2);
        LinkedList.printLL(sortedLL);
    }

}
