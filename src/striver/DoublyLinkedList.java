package striver;

public class DoublyLinkedList {

    public static void printDLL(DNode head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static DNode convertArrToDLL(int[] arr){
        if(arr.length == 0) return null;
        DNode head = new DNode(arr[0]);
        DNode prev = head;

        for(int i = 1; i < arr.length; i++){
            DNode temp = new DNode(prev, arr[i], null);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        DNode head = convertArrToDLL(arr);
        printDLL(head);
    }
}
