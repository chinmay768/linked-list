package striver;

public class FindMidNodeOfLL {

    public static Node findMiddleNaive(Node head) {
        if(head == null) return null;

        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int midPos = (size / 2) + 1;
        int currPos = 1;
        temp = head;
        while (currPos != midPos){
            currPos++;
            temp = temp.next;
        }

        return temp;
    }

    public static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = LinkedList.convertArrayToLL(arr);

        Node midNode = findMiddle(head);
        if(midNode != null)
            System.out.println(midNode.data);
    }
}
