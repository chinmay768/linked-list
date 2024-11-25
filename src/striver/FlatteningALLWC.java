package striver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FlatteningALLWC {

    public static NodeWC flattenNaive(NodeWC head){
        List<Integer> list = new ArrayList<>();

        NodeWC temp = head;
        while (temp != null){
            NodeWC t2 = temp;
            while (t2 != null){
                list.add(t2.data);
                t2 = t2.child;
            }
            temp = temp.next;
        }

        Collections.sort(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        NodeWC flatHead = LinkedListWithChild.convertArrayToLLWC(arr);

        return flatHead;
    }

    public static NodeWC merge(NodeWC head1, NodeWC head2){
        NodeWC dummyNode = new NodeWC(-1);
        NodeWC res = dummyNode;
        while (head1 != null && head2 != null){
            if(head1.data < head2.data){
                res.child = head1;
                res = head1;
                head1 = head1.child;
            }else {
                res.child = head2;
                res = head2;
                head2 = head2.child;
            }
            res.next = null;
        }

        if(head1 != null) res.child = head1;
        if(head2 != null) res.child = head2;

        return dummyNode.child;
    }

    public static NodeWC flatten(NodeWC head){
        if(head == null || head.next == null) return head;

        NodeWC mergedHead = flatten(head.next);
        return merge(head, mergedHead);

    }

    public static void main(String[] args) {
        NodeWC head = new NodeWC(3);
        head.next = new NodeWC(2);
        head.next.child = new NodeWC(10);

        head.next.next = new NodeWC(1);
        head.next.next.child = new NodeWC(7);
        head.next.next.child.child = new NodeWC(11);
        head.next.next.child.child.child = new NodeWC(12);

        head.next.next.next = new NodeWC(4);
        head.next.next.next.child = new NodeWC(9);

        head.next.next.next.next = new NodeWC(5);
        head.next.next.next.next.child = new NodeWC(6);
        head.next.next.next.next.child.child = new NodeWC(8);



        head = flatten(head);
        LinkedListWithChild.printLLWC(head);
    }
}
