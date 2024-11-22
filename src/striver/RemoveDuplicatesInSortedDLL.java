package striver;

public class RemoveDuplicatesInSortedDLL {

    public static DNode removeDuplicates(DNode head){
        if(head == null) return null;

        DNode temp = head;
        while (temp != null && temp.next != null){
            DNode nextNode = temp.next;
            while (nextNode != null && temp.data == nextNode.data){
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 4, 4, 6, 7, 8, 8, 8};
        DNode head = DoublyLinkedList.convertArrToDLL(arr);
        head = removeDuplicates(head);

        DoublyLinkedList.printDLL(head);

    }
}
