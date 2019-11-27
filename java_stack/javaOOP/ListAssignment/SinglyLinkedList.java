public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    
    public int remove() {
        if(head == null) {
            System.out.println("SLL is empty!");
            return 0;
        } else if(head.next == null){
            int val = head.value;
            head = null;
            return val;}
        else {
            Node runner = head;
            while(runner.next.next != null) {
                runner = runner.next;
            }
            int val = runner.next.value;
            runner.next = null;
            return val;
        }
    }
    public void printValues(){
        Node runner = head;
        while (runner != null){
            System.out.println(runner.value);
            runner = runner.next;
        }
    }
    public Node find(int i){
        Node runner = head;
        while (runner != null){
            if (runner.value == i){
                return runner;}
            else{
                runner = runner.next;
            }
            }
        Node empty = new Node(0);
        System.out.println("Value "+i+" not found.");
        return empty;
        }

    public void removeAt(int n){
        if(head == null) {
            System.out.println("SLL is empty!");}
        else if(n == 0) {
            head = head.next;}
        else {
            Node runner = head;
            int count = 0;
            while (count<(n-1)){
                runner = runner.next;
                count += 1;
            }
            runner.next = runner.next.next;
        }
    }
}