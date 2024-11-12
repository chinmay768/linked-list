package striver;

public class SortALinkedListOf0s1s2s {

    public static Node sortNaive(Node head){
        if(head == null) return null;

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        Node temp = head;
        while (temp != null){
            if(temp.data == 0)
                zeroCount++;
            else if(temp.data == 1)
                oneCount++;
            else
                twoCount++;

            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            if(zeroCount != 0){
                temp.data = 0;
                zeroCount--;
            }else if(oneCount != 0){
                temp.data = 1;
                oneCount--;
            }else {
                temp.data =  2;
                twoCount--;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node sort(Node head) {
        if(head == null) return null;

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node temp = head;
        while (temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next != null)? oneHead.next : twoHead.next;
        one.next = twoHead.next;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 2, 1, 1, 0, 2};

        Node head = LinkedList.convertArrayToLL(arr);

        head = sort(head);

        LinkedList.printLL(head);
    }
}
