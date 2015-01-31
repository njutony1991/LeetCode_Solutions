package IntersectionofTwoLinkedLists;

/**
 * Created by tony on 15-1-30.
 */
public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int v){
            this.val = v;
            this.next = null;
        }

        @Override
        public String toString(){
            return " "+val+" ";
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode tailB = headB;
        while(tailB.next!=null)
            tailB = tailB.next;
        tailB.next = headB;
        ListNode p1 = headA;
        ListNode p2 = headA;
        int flag = 0;
        do{
            if(p1!=null&&p1.next!=null)
                p1 = p1.next;
            else {
                flag = 1;
                break;
            }
            if(p2!=null&&p2.next!=null) {
                p2 = p2.next;
                p2 = p2.next;
            }else {
                flag = 1;
                break;
            }
        }while(p1!=p2);

        if(flag==0){
            p1 = headA;
            while(p1!=p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            tailB.next = null;
            return p1;
        }
        else {
            tailB.next = null;
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode n11 = new ListNode(2);
        h1.next = n11;
        ListNode h2 = new ListNode(2);
        ListNode n21 = new ListNode(3);
        h2.next = n21;

        Solution sol = new Solution();
        System.out.println(sol.getIntersectionNode(h1,h2));
    }
}
