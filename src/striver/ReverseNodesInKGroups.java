
package striver;

public class ReverseNodesInKGroups {

    public static Node findKthNode(Node head, int k){
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            k--;
            if(k == 1) return temp;
        }
        return null;
    }

    public static Node reverseNodesInKGroups(Node head, int k){
        if(head == null) return null;

        Node temp = head;
        Node prev = null;
        while (temp != null){
            Node kthNode = findKthNode(temp, k);
            if(kthNode == null){
              if(prev != null) prev.next = temp;
              break;
            }

            Node next = kthNode.next;
            kthNode.next = null;

            Node revHead = ReverseLL.reverseLL(temp); // Not using revHead because already maintaining revHead
            if(temp == head){
                head = kthNode;
            }else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Node head = LinkedList.convertArrayToLL(arr);

        head = reverseNodesInKGroups(head, 3);
        LinkedList.printLL(head);
    }
}
