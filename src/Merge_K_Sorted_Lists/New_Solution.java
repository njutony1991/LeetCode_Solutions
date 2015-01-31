package Merge_K_Sorted_Lists;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class New_Solution {
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
	 
	 static class MinHeap<E>{
		 E[] heaparray = null;
		 Comparator<? super E> orderStd;
		 int size = 0;
		 MinHeap(List<? extends E> lists,Comparator<? super E> OrderStd){
			 this.heaparray = (E[])new Object[lists.size()+1];
			 this.orderStd = OrderStd;
			 int index = 1;
			 for(int i=0;i<lists.size();i++){
				 if(lists.get(i)!=null){
					 heaparray[index++] = lists.get(i);
				 }
			 }
			 this.size = index-1;
			 for(int i=size/2;i>=1;i--){
				 min_heapify(i);
			 }
		 }
		 
		 public boolean isEmpty(){
			 return size==0;
		 }
		 
		 public E extarct_min(){
			 E min = heaparray[1];
			 E last = heaparray[size];
			 heaparray[1] = last;
			 heaparray[size] = null;
			 size--;
			 min_heapify(1);
			 return min;
		 }
		 
		 private void min_heapify(int root){
			 int l = leftchild(root);
			 int r = rightchild(root);
			 int min = -1;
			 if(l<=size&&orderStd.compare(heaparray[root], heaparray[l])>0){
				 min = l;
			 }
			 else
				 min = root;
			 if(r<=size&&orderStd.compare(heaparray[min], heaparray[r])>0){
				 min = r;
			 }
			 if(min!=root){
				 exchange(min,root);
				 min_heapify(min);
			 }
		 }
		 
		 public void heap_insert(E element){
			  size++;
			  heaparray[size]= element;
			  int i = size;
			  while(i>1&&orderStd.compare(heaparray[parent(i)], heaparray[i])>0){
				  int p = parent(i);
				  exchange(i,p);
				  i = p;
			  }
		 }
		 
		 private void exchange(int from,int to){
			 E f = heaparray[from];
			 E t = heaparray[to];
			 heaparray[from] = t;
			 heaparray[to] = f;
		 }
		 
		 private int parent(int i){
			  return i/2;
		 }
		 
		 private int leftchild(int i){
			  return 2*i;
		 }
		 
		 private int rightchild(int i){
			 return 2*i+1;
		 }
	 }

	 public ListNode mergeKLists(List<ListNode> lists) {
		 MinHeap<ListNode> pqueue = new MinHeap<ListNode>(lists,OrderStd);
		 
		 ListNode head = new ListNode(-1);
		 ListNode p = head;
		 
		 while(!pqueue.isEmpty()){
			 ListNode e = pqueue.extarct_min();
			 if(e.next != null)
				 pqueue.heap_insert(e.next);
			 p.next = e;
			 p = e;
		 }
		 return head.next;
	 }
	 
	 public static void main(String[] args){
		 List<ListNode> lists = new LinkedList<ListNode>();
		 ListNode n1 = new ListNode(3);
		 //ListNode n2 = new ListNode(2);
		 //ListNode n3 = new ListNode(4);
		 //n1.next = n2;
		 //n2.next = n3;
		 
		 lists.add(n1);
		 
		 ListNode m1 = new ListNode(1);
		 //ListNode m3 = new ListNode(5);
		 //m1.next = m3;
		 lists.add(m1);
		 
		 New_Solution sol = new New_Solution();
		 ListNode head = sol.mergeKLists(lists);
		 ListNode p = head;
		 while(p!=null)
		 {	System.out.print(p.val+" ");
		 	p = p.next;
		 }
		 System.out.println("");
	 } 
}
