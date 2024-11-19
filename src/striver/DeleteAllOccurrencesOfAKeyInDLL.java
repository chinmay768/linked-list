package striver;

public class DeleteAllOccurrencesOfAKeyInDLL {

    public static DNode deleteAllOccurrencesInDll(DNode head, int key){
        if(head == null) return null;

        DNode temp = head;
        while (temp != null){
            if(temp.data == key){
                if(temp == head){
                    head = head.next;
                }

                DNode prev = temp.prev;
                DNode next = temp.next;
                if(prev != null) prev.next = next;
                if(next != null) next.prev = prev;
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 2, 3, 4, 5, 4, 5};

        DNode head = DoublyLinkedList.convertArrToDLL(arr);

        head = deleteAllOccurrencesInDll(head, 4);
        DoublyLinkedList.printDLL(head);
    }
}
