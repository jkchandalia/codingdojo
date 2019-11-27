public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
    public void setVal(int value){
        this.value = value;
    }
    public int getVal(){
        return value;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return next;
    }
}
