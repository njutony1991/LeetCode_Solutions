package Merge_K_Sorted_Lists;
import java.util.*;
public class Solution {
	 static class ListNode{
		 int val;
		 ListNode next;
		 ListNode(int x){
			 this.val = x;
			 this.next = null;
		 }
	 }
	 static final Comparator<ListNode> OrderStd = new Comparator<ListNode>(){
			@Override
			public int compare(ListNode arg0, ListNode arg1) {
				if(arg0.val > arg1.val)
					return 1;
				if(arg0.val < arg1.val)
					return -1;
				return 0;
			}
	 };
	 public ListNode mergeKLists(List<ListNode> lists) {
		 if(lists.isEmpty()||lists == null)
			 return null;
		 PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(lists.size(),OrderStd);
		 int numoflists = 0;
		 for(int i=0;i<lists.size();i++)
		 {   ListNode listToadd = lists.get(i);
		     if(listToadd!=null)
		     {  pqueue.add(listToadd);
		        numoflists++;
		     }
		 }
		 ListNode head = new ListNode(-1);
		 ListNode p = head;
		 int num = 0;
		 while(num<numoflists){
			 ListNode temp =  pqueue.poll();
			 p.next = temp;
			 p = temp;
			 if(temp.next!=null){
				 pqueue.add(temp.next);
			 }
			 else{
				 num++;
			 }
		 }
		 return head.next;
	 }
	 
	 public static void main(String[] args){
		 List<ListNode> lists = new LinkedList<ListNode>();
		 ListNode n1 = new ListNode(1);
		 ListNode n2 = new ListNode(2);
		 ListNode n3 = new ListNode(4);
		 n1.next = n2;
		 n2.next = n3;
		 
		 lists.add(n1);
		 
		 ListNode m1 = new ListNode(3);
		 ListNode m3 = new ListNode(5);
		 m1.next = m3;
		 lists.add(m1);
		 
		 Solution sol = new Solution();
		 ListNode head = sol.mergeKLists(lists);
		 ListNode p = head;
		 while(p!=null)
		 {	System.out.print(p.val+" ");
		 	p = p.next;
		 }
		 System.out.println("");
	 }
}
