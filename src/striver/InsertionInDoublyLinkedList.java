package striver;

public class InsertionInDoublyLinkedList {

    public static DNode insertBeforeHead(DNode head, int val){
        if(head == null) return new DNode(null, val, null);

        DNode temp = new DNode(null, val, head);
        head.prev = temp;
        head = temp;

        return head;
    }

    public static DNode insertBeforeTail(DNode head, int val){
        if(head == null) return new DNode(null, val, null);

        if(head.next == null){
            DNode temp = new DNode(null, val, head);
            head.prev = temp;
            head = temp;
            return head;
        }

        DNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        DNode newNode = new DNode(temp.prev, val, temp);
        temp.prev.next = newNode;
        temp.prev = newNode;

        return head;
    }

    public static DNode insertBeforeKthNode(DNode head, int val, int pos){
        if(head == null) return null;

        if(pos == 1){
            return insertBeforeHead(head, val);
        }

        int count = 1;
        DNode temp = head;
        while (temp != null){
            if(count == pos){
                break;
            }else {
                temp = temp.next;
                count++;
            }
        }

        DNode prev = temp.prev;
        DNode newNode = new DNode(prev, val, temp);
        prev.next = newNode;
        temp.prev = newNode;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        DNode head = DoublyLinkedList.convertArrToDLL(arr);

//        head = insertBeforeHead(head, 99);
//        head = insertBeforeTail(head, 99);
        head = insertBeforeKthNode(head, 99, 5);
        DoublyLinkedList.printDLL(head);
    }
}
