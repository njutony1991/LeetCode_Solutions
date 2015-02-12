package AddTwoNumbers;

/**
 * Created by tony on 15-2-7.
 */
public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2!=null)
            return l2;
        if(l1!=null&&l2==null)
            return l1;
        if(l1==null&&l2==null)
            return null;

        int step = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);

        ListNode ans = head;

        while(p1!=null&&p2!=null){
            int tmp = p1.val + p2.val + step;
            step = tmp / 10;
            int tmp_val = tmp % 10;
            ans.next = new ListNode(tmp_val);
            p1 = p1.next;
            p2 = p2.next;
            ans = ans.next;
        }

        if(p1!=null||p2!=null){
            if(p1!=null)
                ans.next = p1;
            if(p2!=null)
                ans.next = p2;
            while(ans.next!=null){
                int tmp = ans.next.val+step;
                ans.next.val = tmp % 10;
                step = tmp/10;
                ans = ans.next;
            }
        }
        if(step == 1)
            ans.next = new ListNode(1);
        return head.next;
    }
}
