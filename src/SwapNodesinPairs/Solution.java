package SwapNodesinPairs;

/**
 * Created by tony on 15-2-9.
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
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(-1);
        ListNode pre = h;
        h.next = head;
        while(pre.next != null&&pre.next.next!=null){
            ListNode l = pre.next.next.next;
            ListNode p1 = pre.next;
            ListNode p2 = pre.next.next;
            p1.next = l;
            p2.next = p1;
            pre.next = p2;
            pre = p1;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2; h2.next = h3; h3.next = h4;
        h4.next = h5;
        Solution sol = new Solution();
        ListNode ans = sol.swapPairs(h1);
        ListNode h = ans;
        while(h!=null){
            System.out.print(h.val+" ");
            h = h.next;
        }
        System.out.println("");
    }
}
