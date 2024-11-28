package striver;

import java.util.HashMap;
import java.util.Map;

public class CloneALLWithNextAndRandomPointers {

    public static RNode cloneLLNaive(RNode head){
        RNode temp = head;
        Map<RNode, RNode> map = new HashMap<>();

        while (temp != null){
            map.put(temp, new RNode(temp.data));
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            RNode copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

//    public static RNode cloneLL(RNode head){
//        RNode temp = head;
//
//        while (temp != null){
//            RNode copyNode = new RNode(temp.data);
//            copyNode.next = temp.next;
//            temp.next = copyNode;
//            temp = temp.next.next;
//        }
//
//        temp = head;
//        while (temp != null){
//            // We cannot do next processing here because random is dependent on temp.random.next
//            RNode copyNode = temp.next;
//            if(temp.random != null)
//                copyNode.random = temp.random.next;
//            temp = temp.next.next;
//        }
//
//        RNode dummyNode = new RNode(-1);
//        RNode curr = dummyNode;
//        temp = head;
//        while (temp != null){
//            curr.next = temp.next;
//            temp.next = temp.next.next;
//
//            curr = curr.next;
//            temp = temp.next;
//        }
//
//        return dummyNode.next;
//    }

    public static void main(String[] args) {
        RNode node1 = new RNode(7);
        RNode node2 = new RNode(13);
        RNode node3 = new RNode(11);
        RNode node4 = new RNode(10);
        RNode node5 = new RNode(1);

        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.next = null;
        node5.random = node1;

        RNode cloneLL = cloneLLNaive(node1);
//        RNode cloneLL2 = cloneLL(node1);
        RNode.printLL(cloneLL);

//        System.out.println("/n/n");
//        RNode.printLL(cloneLL2);

    }
}
