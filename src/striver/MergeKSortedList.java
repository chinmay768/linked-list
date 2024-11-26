package striver;

import java.util.*;

public class MergeKSortedList {

    public static Node mergeNaive(List<Node> lists){
        List<Integer> list = new ArrayList<>();

        for (Node temp : lists) {
            while (temp != null) {
                list.add(temp.data);
                temp = temp.next;
            }
        }
        Collections.sort(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return LinkedList.convertArrayToLL(arr);
    }

    public static Node merge2Lists(Node head1, Node head2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                 head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }

            temp = temp.next;
        }

        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;

        return dummyNode.next;
    }

    public static Node mergeNaive2(List<Node> lists){
        Node head = lists.get(0);

        for(int i = 1; i < lists.size(); i++){
            head = merge2Lists(head, lists.get(i));
        }
        return head;
    }

    static  class NodeComparator implements Comparator<Node> {

        public int compare(Node k1, Node k2)
        {
            if (k1.data > k2.data)
                return 1;
            else if (k1.data < k2.data)
                return -1;
            return 0;
        }
    }

    public static Node mergeUsingMinHeap(List<Node> lists){
        Queue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for (int i = 0; i < lists.size(); i++){
            pq.add(lists.get(i));
        }

        if (pq.isEmpty())
            return null;

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (!pq.isEmpty()){
            Node curr = pq.poll();

            temp.next = curr;
            temp = temp.next;

            if(curr.next != null){
                pq.add(curr.next);
            }
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node head1 = LinkedList.convertArrayToLL(new int[] { 2, 4, 6});
        Node head2 = LinkedList.convertArrayToLL(new int[] { 1, 5});
        Node head3 = LinkedList.convertArrayToLL(new int[] { 1, 1, 3, 7});
        Node head4 = LinkedList.convertArrayToLL(new int[] { 8});

        List<Node> list = new ArrayList<>();
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);


        Node mergedHead = mergeUsingMinHeap(list);
        LinkedList.printLL(mergedHead);
    }
}
