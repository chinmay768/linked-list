package striver;

public class Add1ToLL {

    public static Node add1ToLL(Node head, int carry) {
        if(head == null) return null;

        head = ReverseLL.reverseLLNaive(head);

        Node temp = head;
        while (temp != null){
            temp.data = temp.data + carry;

            if(temp.data < 10){
                carry = 0;
                break;
            }
            temp.data = 0;
            temp = temp.next;
            carry = 1;
        }

        if(carry == 1){
            ReverseLL.reverseLLNaive(head);
            Node newNode = new Node(carry, head);
            return newNode;
        }
        ReverseLL.reverseLLNaive(head);
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9};

        Node head = LinkedList.convertArrayToLL(arr);
        head = add1ToLL(head, 1);

        LinkedList.printLL(head);
    }
}
