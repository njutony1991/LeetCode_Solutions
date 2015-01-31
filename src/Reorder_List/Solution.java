package Reorder_List;

public class Solution {
	static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	class Wrapper{
		ListNode node;
		Wrapper pre;
		Wrapper(ListNode node){
			this.node = node;
			this.pre = null;
		}
		
	}
	public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        	return;
        
        Wrapper pre = new Wrapper(head);
        ListNode p = head.next;
        while(p != null){
        	Wrapper temp = new Wrapper(p);
        	temp.pre = pre;
        	
        	p = p.next;
        	pre = temp;
        }
        
        ListNode head_p = head;
        ListNode ans = new ListNode(-1);
        ListNode nextnode = ans;
        int coin = 0;
        while(head_p != pre.node){
        	if(coin==0){
        		nextnode.next = head_p;
        		head_p = head_p.next;
        		
        		nextnode.next.next = null;
        		nextnode = nextnode.next;
        		coin=1;
        	}else{
        		nextnode.next = pre.node;
        		pre.node.next = null;
        		
        		pre = pre.pre;
        		nextnode = nextnode.next;
        		coin=0;
        	}
        }
        nextnode.next = pre.node;
        pre.node.next = null;
        head = ans.next;
    }
	
	public static String toString(ListNode head){
		StringBuffer strbuf = new StringBuffer();
		ListNode p = head;
		while(p != null){
			strbuf.append(p.val+",");
			p = p.next;
		}
		return strbuf.toString();
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		//head.next = n1;
		//n1.next = n2;
		//n2.next = n3;
		new Solution().reorderList(head);
		System.out.println(toString(head));
	}
}
