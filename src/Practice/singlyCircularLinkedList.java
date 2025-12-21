public class singlyCircularLinkedList{

    static Node head;
    static Node tail;
    public static void main(String[] args){

    }

    //O(1)
    public static void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            newNode.next = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    //O(1)
    public static void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            newNode.next = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    //O(1)
    public static void deleteHead(){
        if(head == null) return;
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    public static void deleteTail(){
        if(head == null)return;

        if(head == tail){
            head = tail = null;
            return;
        }

        Node temp = head;
        if(temp.next != tail){
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    public static void delete(int value) {
    if (head == null) return;

    
    if (head == tail && head.data == value) {
        head = tail = null;
        return;
    }

    if (head.data == value) {
        head = head.next;
        tail.next = head;
        return;
    }

    Node curr = head;

    while (curr.next != head && curr.next.data != value) {
        curr = curr.next;
    }

    if (curr.next == head) return;

    if (curr.next == tail) {
        tail = curr;
    }

    curr.next = curr.next.next;
}


    public static void print(){
        if(head == null) return;
        Node temp = head;
        do {
        System.out.print(temp.data + " → ");
        temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}