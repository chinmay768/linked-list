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
            return head;
        }
        Node temp = head;
        Node prev = null;


        int pos = 1;
        while (temp != null){
            if(pos == k){
                prev.next = temp.next;
                break;
            }else {
                pos++;
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }

    public static Node deleteValFromLL(Node head, int val){
        if(head == null) return null;

        if(head.data == val){
            head = head.next;
            return head;
        }

        Node prev = null;
        Node temp = head;

        while (temp != null){
            if(temp.data == val){
                prev.next = temp.next;
                break;
            }else {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }

    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Node head = LinkedList.convertArrayToLL(arr);
//        head = deleteHead(head);
//        head = deleteTail(head);
//        head = deleteKthNode(head, 4);

        head = deleteValFromLL(head, 1);
        LinkedList.printLL(head);
    }
}
