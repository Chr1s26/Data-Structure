public class MergeTwoSortedList{
    public static void main(String[] args){

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode next1 = list1.next;
        ListNode next2 = list2.next;

        if(list1.val >= list2.val){
            list2.next = mergeTwoLists(list1,next2);
            return list2;
        }else{
            list1.next = mergeTwoLists(next1,list2);
            return list1;
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}