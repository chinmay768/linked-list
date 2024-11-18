package striver;

public class DeleteMiddleNodeOfLL {

    public static Node deleteMiddleNodeNaive(Node head){
        if(head == null || head.next == null) return null;

        int size = 0;
        Node temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }

        int dist = (size / 2);
        temp = head;
        while (temp != null){
            dist--;
            if(dist == 0){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteMiddleNode(Node head) {
        if(head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;
        fast = fast.next.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = LinkedList.convertArrayToLL(arr);
        head = deleteMiddleNode(head);

        LinkedList.printLL(head);
    }
}
