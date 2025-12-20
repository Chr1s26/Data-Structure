
public class singlyLinkedList{
    static Node head;
    public static void main(String[] args){
        
        head = new Node(2);
        insertAtHead(1);
        printList();
        insertAtTail(3);
        insertAtTail(4);
        printList();
        deleteAtHead();
        printList();
        delete(3);
        printList();
        insertAtTail(9);
        printList();
        deleteAtTail();
        printList();
    }

    //O(n)
    public static void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //O(1)
    public static void insertAtHead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //O(n)
    public static void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //O(1)
    public static void deleteAtHead(){
        if(head == null) return;
        head = head.next;
    }

    //O(n)
    public static void delete(int value){
        if(head == null) return;

        if(head.data == value){
            head = head.next;
            return;
        }

        Node temp = head;
        while(temp.next != null && temp.next.data != value){
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
        }
    }

    public static void deleteAtTail(){
        if(head == null) return;

        if(head.next == null){
            head = null;
            return;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}