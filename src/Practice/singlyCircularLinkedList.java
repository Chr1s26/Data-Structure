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