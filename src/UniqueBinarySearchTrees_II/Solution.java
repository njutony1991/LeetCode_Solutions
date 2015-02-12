package UniqueBinarySearchTrees_II;
import java.util.*;
/**
 * Created by tony on 15-2-3.
 */
public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        return ans;
    }
}
