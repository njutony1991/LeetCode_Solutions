package RemoveDuplicatesfromSortedList;

public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p!=null&&p.next!=null){
            while(p.next.val == p.val){
                ListNode tmp = p.next;
                p.next = p.next.next;
                tmp.next = null;
                if(p.next==null)
                    return head;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        h1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Solution sol = new Solution();
        ListNode ans = sol.deleteDuplicates(h1);
        ListNode p = ans;
        while(p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println("");
    }
}
