package Insertion_Sort_List;

public class Solution {
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
	
	static private int size(ListNode head){
		int a=1;
		ListNode temp = head;
		while(temp.next != null){
			temp = temp.next;
			a++;
		}
		return a;
	}
	
	private ListNode sortLong(ListNode head,int len){
		ListNode init = new ListNode(-1);
		init.next = head;
		ListNode pre = init.next;
		ListNode index = head.next;
		for(int i=1;i<len;i++){
			int value = index.val;
			ListNode p = init.next;
			ListNode ppre = init;
			for(int j=0;j<i;j++){
				if(p.val>=value)
				{
					break;
				}
				p = p.next;
				ppre = ppre.next;
			}
			if(p.val>=value&&p!=index){
				ListNode temp = index;
				pre.next = temp.next;
				index = temp.next;
				temp.next = p;
				ppre.next = temp;
			}else{
				index = index.next;
				pre = pre.next;
			}
		}
		return init.next;
	}
	
	private ListNode sortList(ListNode head){
		int len = size(head);
		return sortLong(head,len);
	}
	
    public ListNode insertionSortList(ListNode head) {
    	return head==null? null : sortList(head) ;
    } 
    
    static public String toString(ListNode head){
    	StringBuffer ans = new StringBuffer();
    	ListNode index  = head;
    	while(index != null){
    		ans.append(index.val+" ");
    		index = index.next;
    	}
    	return ans.toString();
    }
    
	public static void main(String[] args) {
		ListNode a1 = new ListNode(5000);
		ListNode p = a1;
		for(int i=4999;i>=1;i--){
			ListNode temp = new ListNode(i);
			p.next = temp;
			p = p.next;
		}
		System.out.println(size(a1));
		System.out.println(toString(a1));
		ListNode ans = new Solution().insertionSortList(a1);
		System.out.println(size(ans));
		System.out.println(toString(ans));
	}
}
