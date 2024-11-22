package striver;

public class RotateLLByK {

    public static Node findNewTail(Node head, int pos){
        Node temp = head;
        int count = 1;
        while (temp != null){
            if(count == pos) return temp;
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public static Node rotateByK(Node head, int k){
        if(head == null) return null;

        int size = 1;
        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
            size++;
        }

        if(k % size == 0) return head;
        k = k % size;
        tail.next = head;
        Node newTail = findNewTail(head, size - k);

        head = newTail.next;
        newTail.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = LinkedList.convertArrayToLL(arr);
        head = rotateByK(head, 3);

        LinkedList.printLL(head);
    }
}
