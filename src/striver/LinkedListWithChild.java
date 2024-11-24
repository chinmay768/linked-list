package striver;

public class LinkedListWithChild {
    public static void printLLWC(NodeWC head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.child;
        }
    }

    public static NodeWC convertArrayToLLWC(int[] arr){
        if(arr.length == 0) return null;

        NodeWC head = new NodeWC(arr[0]);
        NodeWC mover = head;
        for(int i = 1; i < arr.length; i++){
            NodeWC newNode = new NodeWC(arr[i]);
            mover.child = newNode;
            mover = mover.child;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        NodeWC head = convertArrayToLLWC(arr);

        printLLWC(head);
    }
}
