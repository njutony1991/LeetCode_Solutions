package Binary_Tree_Postorder_Traversal;
import java.util.*;
public class Solution {
	
	  static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	  }
	  
	  class Wrapper{
		  TreeNode node;
		  int left = 0;
		  int right = 0;
		  Wrapper(TreeNode node){
			  this.node = node;
		  }
		  
		  public String toString(){
			  return this.node.val+" ";
		  }
	  }
	  
	  public List<Integer> postorderTraversal(TreeNode root) {
		  	
		    List<Integer> ans = new LinkedList<Integer>();
		    if(root==null)
		    	return ans;
		    LinkedList<Wrapper> stack = new LinkedList<Wrapper>();
		    Wrapper w_root = new Wrapper(root);
		    stack.add(w_root);
		    while(true){
		    	if(stack.isEmpty()) 
		    		break;
		    	if(stack.peekLast().left==0){
		    		stack.peekLast().left = 1;
		    		TreeNode p = stack.peekLast().node;
		    		while(p.left!=null)
		    		{
		    			Wrapper temp = new Wrapper(p.left);
		    			temp.left = 1;
		    			stack.add(temp);
		    			p = p.left;
		    		}
		    	}
		    	Wrapper w_p = stack.pollLast();
		    	if(w_p.left == 1&& w_p.right==0)
		    	{	w_p.right = 1;
		    		stack.add(w_p);
		    		if(w_p.node.right!=null){
		    			Wrapper rw_p = new Wrapper(w_p.node.right);
		    			stack.add(rw_p);
		    		}
		    	}
		    	else if(w_p.right == 1){
		    		ans.add(w_p.node.val);
		    	}
		    	//System.out.println(stack);
		    }
	        return ans;
	  }
	  
	  public static void main(String[] args){
		  TreeNode root = new TreeNode(1);
		  TreeNode right  = new TreeNode(2);
		  TreeNode rleft = new TreeNode(3);
		  root.left = right;
		 // root.left = null;
		  root.right = rleft;
		 // right.right = null;
		  
		  System.out.println("ans: "+new Solution().postorderTraversal(root));
	  }
}
