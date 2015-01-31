package BinaryTreePreorderTraversal;
import java.util.*;


public class Solution {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	
	class Wrapper{
		TreeNode node;
		int left;
		int right;
		Wrapper(TreeNode node){
			this.node = node;
			this.left = 0;
			this.right = 0;
		}
		
		public String toString(){
			return new Integer(node.val).toString();
		}
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> ans = new LinkedList<Integer>();
	    if(root == null) 
	    	return ans;
	    LinkedList<Wrapper> stack = new LinkedList<Wrapper>();
	    Wrapper w_root = new Wrapper(root);
	    stack.add(w_root);
	    ans.add(root.val);
	    
	    while(!stack.isEmpty()){
	    	System.out.println(stack);
	    	if(stack.peekLast().left == 0){
	    		stack.peekLast().left = 1;
	    		TreeNode p = stack.peekLast().node;
	    		while(p.left!=null){
	    			Wrapper temp = new Wrapper(p.left);
	    			temp.left = 1;
	    			stack.add(temp);
	    			ans.add(temp.node.val);
	    			p = p.left;
	    		}
	    	}
	    	
	    	Wrapper w_p = stack.pollLast();
	    	if(w_p.left==1&&w_p.right==0){
	    		w_p.right = 1;
	    		TreeNode temp = w_p.node;
	    		if(temp.right != null){
	    			stack.add(new Wrapper(temp.right));
	    			ans.add(temp.right.val);
	    		}
	    	}
	    }
		return ans;
	}

	
	public static void main(String[] args) {
		  TreeNode root = new TreeNode(1);
		  TreeNode right  = new TreeNode(2);
		  TreeNode rleft = new TreeNode(3);
		  root.left = rleft;
		 // root.left = null;
		  //root.right = rleft;
		  root.right = right;
		  
		  System.out.println("ans: "+new Solution().preorderTraversal(root));

	}
}
