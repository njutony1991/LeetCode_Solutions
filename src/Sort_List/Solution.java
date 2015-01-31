package Sort_List;

public class Solution {
	 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	 }
	 
	 ListNode merge(ListNode list1,ListNode list2){

		 ListNode ans = new ListNode(-1);
		 ListNode h1 = list1;
		 ListNode h2 = list2;
		 ListNode h3 = ans;
		 
		 while(h1!=null&&h2!=null){
			 if(h1.val<h2.val){
				 h3.next = h1;
				 h1 = h1.next;
				 h3.next.next = null;
				 h3 = h3.next;
			 }
			 else if(h2.val<h1.val){
				 h3.next = h2;
				 h2 = h2.next;
				 h3.next.next = null;
				 h3 = h3.next;
			 }
			 else if(h2.val==h1.val){
				h3.next = h1;
				h1 = h1.next;
				h3.next.next = null;
				h3 = h3.next;
				
				h3.next = h2;
				h2 = h2.next;
				h3.next.next = null;
				h3 = h3.next;
			 }
		 }
		 
		 if(h1!=null){
			 while(h1!=null){
				 h3.next = h1;
				 h1 = h1.next;
				 h3.next.next = null;
				 h3 = h3.next;
			 }
		 }
		 
		 if(h2!=null){
			 while(h2!=null){
				 h3.next = h2;
				 h2 = h2.next;
				 h3.next.next = null;
				 h3 = h3.next;
			 }
		 }
		 
		 ans = ans.next;
		 return ans;
	 }
	 
	 int getSize(ListNode head){
		 int ans = 0;
		 ListNode h = head;
		 while(h != null){
			 ans++;
			 h = h.next;
		 }
		 return ans;
	 }
	 
	 ListNode[] split(ListNode head){
		 ListNode[] lists = new ListNode[2];
		 int size = getSize(head);
		 if(size != 0){
			 int len1 = (size+1)/2;
			 int i = 1;
			 ListNode h = head;
		 
			 while(i<len1){
				 h = h.next;
				 i++;
			 }

			 ListNode temp = h;
			 h = h.next;
			 temp.next = null;
			 lists[0] = head;
			 //printList(lists[0]);
			 lists[1] = h;
			 //printList(lists[1]);
			 //System.out.println("---------------");
		 }
		
		 return lists;
	 }
	 
	 ListNode mergeSort(ListNode head){
		 if(getSize(head)>1){
			 ListNode[] lists = split(head);
			 ListNode l1 = mergeSort(lists[0]);
			 //printList(l1);
			 ListNode l2 = mergeSort(lists[1]);
			 //printList(l2);
			 ListNode ans = merge(l1,l2);
			 return ans;
		 }
		 return head;
	 }
	 
	 public ListNode sortList(ListNode head) {
		 if(head==null)
			 return null;
		 else 
		 {
			 ListNode ans = mergeSort(head);
			 return ans;
		 }
	 }
	 
	  void printList(ListNode head){
		 ListNode h = head;
		 while(h != null){
			 System.out.print(h.val+" ");
			 h = h.next;
		 }
		 System.out.println("");
	 }
	  
	 public static void main(String[] args){
		 ListNode head = new ListNode(5);
		 ListNode f1 = new ListNode(4);
		 head.next = f1;
		 ListNode f2 = new ListNode(3);
		 f1.next = f2;
		 ListNode f3 = new ListNode(2);
		 f2.next = f3;
		 ListNode ans = new Solution().sortList(head);
		 ListNode head1 = ans;
		 while(head1 != null){
			 System.out.print(head1.val+" ");
			 head1 = head1.next;
		 }
		 System.out.println("");
		 
	 }
}
