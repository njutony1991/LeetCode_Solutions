package Path_Sum;

public class Solution {
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	boolean flag = false;
	void dfs(TreeNode root,int sum){
		if(root.left==null&&root.right==null){
			if(sum==0){
				flag = true;
			}
			return;
		}
		if(root.left!=null){
			sum = sum-root.left.val;
			dfs(root.left,sum);
			sum += root.left.val;
			if(flag==true) return;
		}
		if(root.right!=null){
			sum = sum-root.right.val;
			dfs(root.right,sum);
			sum += root.right.val;
			if(flag==true) return;
		}
	}
	public boolean hasPathSum(TreeNode root,int sum){
		if(root!=null)
			dfs(root,sum-root.val);
		return flag;
	}
	/**
	 * for test
	 * 
	 */
	  public  TreeNode construct(int[] nodes){
	    	TreeNode[] treenodes = new TreeNode[nodes.length];
	    	treenodes[0] = new TreeNode(nodes[0]);
	    	for(int i=1;i<nodes.length;i++){
	    		if(nodes[i] != -1){
	    			treenodes[i]=new TreeNode(nodes[i]);
	    			if(i%2==1)
	    				treenodes[i/2].left=treenodes[i];
	    			if(i%2==0)
	    				treenodes[i/2-1].right=treenodes[i];
	    		}
	    	}
	    	return treenodes[0];
	    }
	  
	public static void main(String[] args) {
		int[] nums = new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,-1,5,1};
		TreeNode root = new Solution().construct(nums);
		System.out.println(new Solution().hasPathSum(root, 22));
	}

}
