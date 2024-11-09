package striver;

public class InsertionInLinkedList {

    public static Node insertBeforeHead(Node head, int val){
        if(head == null) return null;

        Node newNode = new Node(val, head);

        head = newNode;
        return head;
    }

    public static Node insertAtEnd(Node head, int val){
        if(head == null) return new Node(val, null);

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = new Node(val, null);

        return head;
    }

    public static Node insertAtPos(Node head, int val, int pos){
        if(head == null) {
            if(pos == 1) return new Node(val, null);
            else return null;
        }

        if(pos == 1){
            return new Node(val, head);
        }

        int count = 1;
        Node temp = head;

        while (temp != null){
            if(count == pos - 1){
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }else{
                temp = temp.next;
            }
            count++;
        }

        return head;
    }

    public static Node insertBeforeElm(Node head, int val, int elmVal){
        if(head == null) return null;

        if(head.data == elmVal) return new Node(val, head);

        Node temp = head;
        while (temp.next != null){
            if(temp.next.data == elmVal){
                temp.next = new Node(val, temp.next);
                break;
            }else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Node head = LinkedList.convertArrayToLL(arr);

//        head = insertBeforeHead(head, 99);
//        head = insertAtEnd(head, 99);
//        head = insertAtPos(head, 99, 1);

        head = insertBeforeElm(head, 99, 11);
        LinkedList.printLL(head);

    }
}
