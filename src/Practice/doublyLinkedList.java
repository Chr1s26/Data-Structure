public class doublyLinkedList{

    static Node head;
    static Node tail;

    //null ← 10 ⇄ 20 ⇄ 30 → null
    public static void main(String[] args){
        insertAtHead(1);
        printForward();
        System.out.println();
        insertAtTail(2);
        insertAtTail(3);
        printForward();
        System.out.println();
        printBackward();
        insertAtTail(4);
        deleteHead();
        System.out.println();
        printForward();
        deleteTail();
        System.out.println();
        printForward();
        delete(3);
        System.out.println();
        printForward();
    }

    //O(1)
    public static void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //O(1)
    public static void insertAtTail(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
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
        head.prev = null;
    }

    //O(1)
    public static void deleteTail(){
        if(tail == null) return;
        
        if(head == tail){
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public static void delete(int data){
        if(head == null) return;
        
        if(head.data == data){
            if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
                head.prev = null;
            }
            return;
        }

        Node temp = head;
        while(temp.next != null && temp.next.data != data){
            temp = temp.next;
        }
        if(temp.next == null) return;

        if(temp.next == tail){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            Node toDelete = temp.next;
            temp.next = toDelete.next;
            toDelete.next.prev = temp;
        }
    }

    public static void printForward(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"⇄");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void printBackward(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data+"⇄");
            temp = temp.prev;
        }
        System.out.print("null");
    }

    static class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

}