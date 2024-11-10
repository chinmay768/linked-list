package striver;

public class DeletionInDoublyLinkedList {

    public static DNode deleteHeadInDLL(DNode head){
        if(head == null || head.next == null) return null;

        head = head.next;
        head.prev = null;
        return head;
    }

    public static DNode deleteTailInDLL(DNode head){
        if(head == null || head.next == null) return null;

        DNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        DNode prev = temp.prev;
        prev.next = null;
        return head;
    }

    public static DNode deleteKthNode(DNode head, int pos){
        if(head == null) return null;

        DNode temp = head;
        int count = 1;
        while (temp != null){
            if(count == pos){
                break;
            }else{
                temp = temp.next;
                count++;
            }
        }


        if(temp != null){
            if(temp.prev == null && temp.next == null){
                return null;
            }else if(temp.prev == null){
                //delete head
                head = head.next;
                head.prev = null;
            }else if(temp.next == null){
                //delete tail
                DNode prev = temp.prev;
                prev.next = null;
            }else {
                DNode prev = temp.prev;
                DNode next = temp.next;
                prev.next = next;
                next.prev = prev;
            }
        }

        return head;
    }

    public static DNode deleteNodeWithVal(DNode head, int val){
        if(head == null) return null;

        DNode temp = head;
        while (temp != null){
            if(temp.data == val){
                break;
            }else{
                temp = temp.next;
            }
        }


        if(temp != null){
            if(temp.prev == null && temp.next == null){
                return null;
            }else if(temp.prev == null){
                //delete head
                head = head.next;
                head.prev = null;
            }else if(temp.next == null){
                //delete tail
                DNode prev = temp.prev;
                prev.next = null;
            }else {
                DNode prev = temp.prev;
                DNode next = temp.next;
                prev.next = next;
                next.prev = prev;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        DNode head = DoublyLinkedList.convertArrToDLL(arr);

//        head = deleteHeadInDLL(head);
//        head = deleteTailInDLL(head);
//        head = deleteKthNode(head, 4);
        head = deleteNodeWithVal(head, 1);
        DoublyLinkedList.printDLL(head);
    }
}

// Write function for before and after kth elme