package BinaryTreeLevelOrderTraversal_II;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tony on 15-1-31.
 */
public class Solution {
    private class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val = x;}
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null)
            return ans;
        queue1.add(root);
        while((!queue1.isEmpty())||(!queue2.isEmpty())){
            LinkedList<Integer> row1 = new LinkedList<Integer>();
            while(!queue1.isEmpty()){
                TreeNode tmp = queue1.pollFirst();
                row1.add(tmp.val);
                if(tmp.left!=null)
                    queue2.add(tmp.left);
                if(tmp.right!=null)
                    queue2.add(tmp.right);
            }
            if(!row1.isEmpty())
                ans.addFirst(row1);

            LinkedList<Integer> row2 = new LinkedList<Integer>();
            while(!queue2.isEmpty()){
                TreeNode tmp = queue2.pollFirst();
                row2.add(tmp.val);
                if(tmp.left!=null)
                    queue1.add(tmp.left);
                if(tmp.right!=null)
                    queue1.add(tmp.right);
            }
            if(!row2.isEmpty())
                ans.addFirst(row2);
        }
        return ans;
    }
}
