package MinimumDepthofBinaryTree;

/**
 * Created by tony on 15-2-12.
 */
public class Solution {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){
            this.val= x;
        }
    }

    int dfs(TreeNode r,int h){
        if(r.left==null&&r.right==null)
            return h;
        else
        if(r.left!=null&&r.right!=null)
            return Math.min(dfs(r.left,h+1),dfs(r.right,h+1));
        else
        if(r.left==null)
            return dfs(r.right,h+1);
        else
            return dfs(r.left,h+1);
    }
    public int minDepth(TreeNode root) {
        int ans = dfs(root,1);
        return ans;
    }
}
