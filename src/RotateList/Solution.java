package RotateList;

/**
 * Created by tony on 15-2-11.
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

    public ListNode rotateRight(ListNode head, int n) {
        if(head==null)
            return null;
        int len = 0;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode h1 = pre;
        while(h1.next!=null){
            len++;
            h1=h1.next;
        }

        int shift = n%len;
        if(shift == 0){
            return head;
        }

        h1.next = head;
        int next_shift = len - shift;
        ListNode h2 = pre;
        for(int j=0;j<=next_shift;j++){
            h2=h2.next;
        }

        ListNode ans = h2.next;
        h2.next = null;
        return ans;
    }
}
