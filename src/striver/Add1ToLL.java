package striver;

public class Add1ToLL {

    public static Node add1ToLL(Node head, int carry) {
        if(head == null) return null;

        head = ReverseLL.reverseLLNaive(head);

        Node temp = head;
        while (carry != 0){
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
            Node newNode = new Node(carry, head);
            ReverseLL.reverseLLNaive(newNode);
            return newNode;
        }
        ReverseLL.reverseLLNaive(head);
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};

        Node head = LinkedList.convertArrayToLL(arr);
        head = add1ToLL(head, 1);

        LinkedList.printLL(head);
    }
}
