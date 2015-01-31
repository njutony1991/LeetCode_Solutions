package LinkedListCycle;

public class Solution {
	 class ListNode{
		 int val;
		 ListNode next;
		 ListNode(int x){
			 val = x;
			 next = null;
		 }
	 }
	 public boolean hasCycle(ListNode head) {
		 	if(head==null) return false;
	        ListNode slowPtr = head;
	        ListNode fastPtr = head;
	        boolean flag = true;
	        do{
	        	if(fastPtr.next == null ||fastPtr.next.next == null){
	        		flag = false;
	        		break;
	        	}
	        	slowPtr = slowPtr.next;
	        	fastPtr = fastPtr.next.next;
	        }while(slowPtr != fastPtr);
	        return flag;
	 }
}
