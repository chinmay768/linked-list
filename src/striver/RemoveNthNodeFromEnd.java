package striver;

public class RemoveNthNodeFromEnd {

    public static Node removeNthNodeFromEndNaive(Node head, int n){
        if(head == null) return null;

        Node currNode = head;
        int size = 0;
        while (currNode != null){
            size++;
            currNode = currNode.next;
        }

        if(n == size){
            return head.next;
        }else if(n > size || n <= 0)
            return head;

        int pos = 1;
        currNode = head;
        while (currNode != null){
            if(pos == size - n){
                break;
            }
            pos++;
            currNode = currNode.next;
        }


        currNode.next = currNode.next.next;
        return head;
    }

    public static Node removeNthNodeFromEnd(Node head, int n){
//        Note this only works if n is from 1 to size of LL
        if(head == null) return head;

        Node slow = head;
        Node fast = head;

        for(int i = 0; i < n; i++)
            fast = fast.next;

        if(fast == null)
            return head.next;


        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = LinkedList.convertArrayToLL(arr);
        head = removeNthNodeFromEnd(head, 2);

        LinkedList.printLL(head);
    }
}
