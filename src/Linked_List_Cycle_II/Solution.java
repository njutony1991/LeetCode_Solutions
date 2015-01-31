package Linked_List_Cycle_II;

public class Solution {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	   public ListNode detectCycle(ListNode head) {
		   if(head==null) return null;
	       ListNode slowPtr = head;
	       ListNode fastPtr = head;
	       boolean flag = true;
	       do{
	    	   if(fastPtr.next == null||fastPtr.next.next == null){
	    		   flag = false;
	    		   break;
	    	   }
	    	   slowPtr = slowPtr.next;
	    	   fastPtr = fastPtr.next;
	    	   fastPtr = fastPtr.next;
	       }while(slowPtr!=fastPtr);
	       if(flag == false )
	    	   return null;
	       else{
	    	   slowPtr = head;
	    	   while(slowPtr != fastPtr){
	    		   slowPtr = slowPtr.next;
	    		   fastPtr = fastPtr.next;
	    	   }
	    	   return slowPtr;
	       }
	    }
}
