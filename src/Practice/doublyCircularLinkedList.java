public class doublyCircularLinkedList{

    static Node head;
    static Node tail;
    public static void main(String[] args){

    }

    //O(1)
    public static void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            head.next = tail.prev = head;
            return;
        }
        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
        head = newNode;
    }

    //O(1)
    public static void insertAtTail(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head;
            return;
        }

        newNode.prev = tail;
        newNode.next = head;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;

    }


    //O(1)
    public static void deleteHead() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = tail;
        tail.next = head;
    }


    //O(1)
    public static void deleteTail() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
    }

    //O(n)
    public static void delete(int value){
        if(head == null) return;

        if(head == tail && head.data == value){
            head = tail = null;
            return;
        }

        if(head.data == value){
            head = head.next;
            head.prev = tail;
            tail.next = head;
            return;
        }

        Node temp = head;
        while(temp != head && temp.data != value){
            temp = temp.next;
        }

        if(temp == head){
            return;
        }

        if(temp == tail){
            tail = temp.prev;
            tail.next = head;
            head.prev = tail;
        }
        else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public static void printForward() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }


    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}