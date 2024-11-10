package striver;

public class DNode {
    DNode prev;
    int data;
    DNode next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    DNode(DNode prev, int data, DNode next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
