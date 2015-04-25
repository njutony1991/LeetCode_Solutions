package RemoveNthNodeFromEndofList;

/**
 * Created by tony on 15-2-12.
 */
public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        if(n==0)
            return head;
        ListNode p1,p2;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        p1 = pre;
        for(int i=0;i<n&&p1!=null;i++)
            p1 = p1.next;
        if(p1!=null&&p1.next==null)
            return head.next;
        if(p1==null)
            return head;
        p2 = pre;
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode rest = p2.next.next;
        p2.next = rest;
        return head;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        h.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution sol = new Solution();
        ListNode ans = sol.removeNthFromEnd(h,5);
        ListNode p = ans;
        while(p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println("");
    }
}
