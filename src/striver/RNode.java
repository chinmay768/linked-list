package striver;

public class RNode {
    //Node with Random
    int data;
    RNode next;
    RNode random;

    RNode(int data){
        this.data = data;
    }

    RNode(int data, RNode next, RNode random){
        this.data = data;
        this.next = next;
        this.random = random;
    }

    public static void printLL(RNode head){
        RNode temp = head;
        while (temp != null){
//            if(temp.next == null && temp.random != null){
//                System.out.println(temp.data + " null " + temp.random);
//            }else if(temp.random == null && temp.next != null){
//                System.out.println(temp.data + " " + temp.next + " null ");
//            }else if(temp.next == null && temp.random == null){
//                System.out.println(temp.data + " null " + " null ");
//            }
            if(temp.next == null || temp.random == null){

                if(temp.next == null){
                    System.out.println(temp.data + " null " + temp.random.data);
                }else if (temp.random == null && temp.next != null){
                    System.out.println(temp.data + " " + temp.next.data + " null ");
                }else{
                    System.out.println(temp.data + " null "  + " null ");
                }
                temp = temp.next;
                continue;
            }
            System.out.println(temp.data + " " + temp.next.data + " " + temp.random.data);
            temp = temp.next;
        }
    }
}
