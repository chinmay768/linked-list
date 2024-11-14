package striver;

import java.util.Stack;

public class CheckIfLLIsPalindrome {

    public static Node reverseLL(Node head) {
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node temp = head;
        while (temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public static Boolean checkPalindromeNaive(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            if(temp.data != stack.pop()) return false;

            temp = temp.next;
        }

        return true;
    }

    public static Boolean checkPalindrome(Node head) {
        if(head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node revHead = reverseLL(slow.next);

        Node temp1 = head;
        Node temp2 = revHead;
        while (temp2 != null){
            if(temp1.data != temp2.data){
                reverseLL(revHead);
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        reverseLL(revHead);

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};

        Node head = LinkedList.convertArrayToLL(arr);
        Boolean isPalindrome =  checkPalindrome(head);

        if(isPalindrome){
            System.out.println("The given LL is a palindrome");
        }else {
            System.out.println("The given LL is not a palindrome");
        }

    }
}
