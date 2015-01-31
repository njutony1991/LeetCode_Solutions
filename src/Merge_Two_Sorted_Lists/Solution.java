package Merge_Two_Sorted_Lists;
public class Solution {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = new ListNode(-1);
		ListNode p3 = head;
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				ListNode temp = p1.next;
				p1.next = null;
				p3.next = p1;
				p3 = p3.next;
				p1 = temp;
			}
			else if(p1.val>p2.val){
				ListNode temp = p2.next;
				p2.next = null;
				p3.next = p2;
				p3 = p3.next;
				p2 = temp;
			}
			else if(p1.val==p2.val){
				ListNode temp1 = p1.next;
				p1.next = null;
				p3.next = p1;
				p3 = p3.next;
				p1 = temp1;
				
				ListNode temp2 = p2.next;
				p2.next = null;
				p3.next = p2;
				p3 = p3.next;
				p2 = temp2;
			}
		}
		if(p1==null){
			p3.next = p2;
		}
		if(p2==null){
			p3.next = p1;
		}
		
		p3 = head;
		head = head.next;
		p3.next = null;
		p3 = null;
		return head;
	}
	
	ListNode construct(int[] list){
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for(Integer i : list){
			ListNode node = new ListNode(i);
			p.next = node;
			p = p.next;
		}
		p = head;
		head = head.next;
		p.next =null;
		p = null;
		return head;
	}
	
	void print(ListNode list){
		ListNode head = list;
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println("");
	}
	public static void main(String[] args){
		Solution  sol = new Solution();
		ListNode l1 = sol.construct(new int[]{1});
		sol.print(l1);
		ListNode l2 = sol.construct(new int[]{1});
		sol.print(l2);
		ListNode ans = sol.mergeTwoLists(l1, l2);
		sol.print(ans);
	}
}
