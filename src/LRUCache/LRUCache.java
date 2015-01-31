package LRUCache;
import java.util.*;
public class LRUCache {
	class Node{
		int key;
		Node pre;
		Node next;
		Node(int key){
			this.key = key;
			this.pre = null;
			this.next = null;
		}
	 }
	 Node header;
	 HashMap<Integer,Integer> pairs;
	 HashMap<Integer,Node> keyindex;
	 int capacity = 0;
	 public LRUCache(int capacity) {
		 	this.header = new Node(-1);
		 	this.header.next = this.header;
		 	this.header.pre = this.header;
	        this.capacity = capacity;
	        this.pairs = new HashMap<Integer,Integer>();
	        this.keyindex = new HashMap<Integer,Node>();
	 }
	    
	 public int get(int key) {
	    	if(pairs.containsKey(key)){
	    		int value = pairs.get(key);
	    		Node keynode = keyindex.get(key);
	    	    remove(keynode);
	    		addToHead(keynode);
	    		return value;
	    	}
	    	else
	    		return -1;
	 }
	    
	 public void set(int key, int value) {
	        if(!pairs.containsKey(key)){
	        	if(pairs.size()==capacity){
	        		Node removedkey = removeLast();
	        		keyindex.remove(removedkey.key);
	        		pairs.remove(removedkey.key);
	        	}
	        		Node newkey = new Node(key);
	        		addToHead(newkey);
	        		pairs.put(key,value);
	        		keyindex.put(key, newkey);
	        }else{
	        	pairs.put(key, value);
	        	Node keynode = keyindex.get(key);
	        	remove(keynode);
	        	addToHead(keynode);
	        }
	 }
	 
	 private void remove(Node keynode){
		 Node prenode = keynode.pre;
		 Node sucnode = keynode.next;
		 prenode.next = sucnode;
		 sucnode.pre = prenode;
		 keynode.pre = null;
		 keynode.next = null;
	 }
	 
	 private void addToHead(Node keynode){
		 Node nextToHeader = header.next;
		 keynode.next = nextToHeader;
		 nextToHeader.pre = keynode;
		 header.next = keynode;
		 keynode.pre = header;
	 }
	 
	 private Node removeLast(){
		 Node ans = header.pre;
		 Node pre = ans.pre;
		 pre.next = header;
		 header.pre = pre;
		 ans.next = null;
		 ans.pre = null;
		 return ans;
	 }
	 
}
