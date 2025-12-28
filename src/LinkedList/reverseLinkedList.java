public class reverseLinkedList{
    public static void main(String[] args){
        
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode left = head;
        ListNode right = head.next;

        while(right != null){
            ListNode dummy = right.next;
            right.next = left;
            left = right;
            right = dummy;
        }
        head.next = null;
        head = left;
        return head;
    }

    public static ListNode reverseListV1(ListNode head) {
        if(head == null || head.next == null) return head;

        //temp = 5, head = 3
        ListNode temp = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;

        return temp; 
    }

static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}