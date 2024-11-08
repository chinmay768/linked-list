package striver;

public class DeletionInLinkedList {

    public static Node deleteHead(Node head){
        if(head == null) return null;

        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteKthNode(Node head, int k){
        if (head == null) return null;
        if(k == 1){
            head = head.next;
            
        }
        Node temp = head;
        Node prev = null;


        int pos = 1;

        while (temp != null){
            if(pos == k){
                prev.next = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Node head = LinkedList.convertArrayToLL(arr);
        head = deleteHead(head);

        LinkedList.printLL(head);
    }
}
