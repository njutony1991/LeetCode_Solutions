package Path_Sum_II;
import java.util.*;
public class Solution {
 class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public  void dfs(TreeNode root,int sum,List<List<Integer>>ans,List<Integer>list){
		if(root.left==null&&root.right==null){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
			int sum1 =0;
			for(Integer i:list){
				sum1+=i;
			}
			if(sum1==sum)
				ans.add(new LinkedList<Integer>(list));
			return;
		}
		if(root.left != null)
		{
			list.add(root.left.val);
			dfs(root.left,sum,ans,list);
			list.remove(list.size()-1);
		}
		if(root.right != null){
			list.add(root.right.val);
			dfs(root.right,sum,ans,list);
			list.remove(list.size()-1);
		}
	}
    public  List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root!=null){
        List<Integer> list = new LinkedList<Integer>();
        list.add(root.val);
        dfs(root,sum,ans,list);
        }
        return ans;
    }

    // for test
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
		List<List<Integer>> ans = new Solution().pathSum(root,22);
		for(List<Integer> list :ans){
			for(Integer i : list){
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}

}
