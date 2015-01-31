package BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;
public class Solution {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val=x;}
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	if(root==null) return new LinkedList<List<Integer>>();
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty()||!queue2.isEmpty()){
        	List<Integer> l1 = new LinkedList<Integer>();
        	List<Integer> l2 = new LinkedList<Integer>();
         	while(!queue1.isEmpty()){
        		TreeNode temp = queue1.poll();
        		l1.add(temp.val);
        		if(temp.left!=null)
        			queue2.add(temp.left);
        		if(temp.right!=null)
        			queue2.add(temp.right);
        		}
         	while(!queue2.isEmpty()){
         		TreeNode temp = queue2.poll();
         		l2.add(temp.val);
         		if(temp.left!=null)
         			queue1.add(temp.left);
         		if(temp.right!=null)
         			queue1.add(temp.right);
         	}
         	if(!l1.isEmpty())
         		ans.add(l1);
         	if(!l2.isEmpty())
         	{
         		LinkedList<Integer> reversed = new LinkedList<Integer>();
         		for(int i=l2.size()-1;i>=0;i--)
         			reversed.add(l2.get(i));
         		ans.add(reversed);
         	}
        }
        return ans;
    }
}
