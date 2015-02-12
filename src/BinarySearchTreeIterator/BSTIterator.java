package BinarySearchTreeIterator;

/**
 * Created by tony on 15-2-2.
 */
import java.util.*;
public class BSTIterator {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    private TreeNode cur = null;
    private TreeNode root = null;
    private LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.cur = root;
        while(cur!=null){
            stack.addLast(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pollLast();
        int smallest = top.val;
        if(top.right!=null)
        {
            TreeNode nextnode = top.right;
            while(nextnode!=null){
                stack.addLast(nextnode);
                nextnode = nextnode.left;
            }
        }
        return smallest;
    }
}
