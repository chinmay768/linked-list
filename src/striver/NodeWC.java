package striver;

public class NodeWC {
    //Node with child
    int data;
    NodeWC next;
    NodeWC child;

    NodeWC(int data){
        this.data = data;
    }

    NodeWC(int data, NodeWC next, NodeWC child){
        this.data = data;
        this.next = next;
        this.child = child;
    }
}
