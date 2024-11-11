package striver;

public class AddTwoNumbersInLL {

    public static Node addTwoNumsWithDummyNode(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;


        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        int carry = 0;
        while (temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null)  sum += temp1.data;
            if(temp2 != null) sum += temp2.data;

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new Node(sum, null);
            curr = curr.next;


            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }

        if(carry != 0){
            curr.next = new Node(carry, null);
        }

        return dummyNode.next;
    }

    public static Node addTwoNumsWithoutDummyNode(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;


        Node head = null;
        Node curr = head;
        int carry = 0;
        while (temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null)  sum += temp1.data;
            if(temp2 != null) sum += temp2.data;

            carry = sum / 10;
            sum = sum % 10;

            if(head == null){
                head = new Node(sum, null);
                curr = head;
            }else {
                curr.next = new Node(sum, null);
                curr = curr.next;
            }

            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }

        if(carry != 0){
            curr.next = new Node(carry, null);
        }

        return head;
    }

    public static void main(String[] args) {
//        Note: LL will be given in reverse order which will eventually help in adding
//        When you need to create a new LL always use dummy node to make it simple
        int[] arr1 = {3, 5}; // 35
        int[] arr2 = {4, 5, 9, 9}; // 9945 + 53   10007

        Node head1 = LinkedList.convertArrayToLL(arr1);
        Node head2 = LinkedList.convertArrayToLL(arr2);


        Node head = addTwoNumsWithDummyNode(head1, head2); //
        LinkedList.printLL(head);
    }
}
