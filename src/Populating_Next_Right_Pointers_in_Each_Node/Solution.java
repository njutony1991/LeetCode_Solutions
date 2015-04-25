package Populating_Next_Right_Pointers_in_Each_Node;

/**
 * Created by tony on 15-2-12.
 */
public class Solution {
    class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x){
            this.val = x;
        }
    }
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while(level_start!=null){
            TreeLinkNode cur = level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next = cur.right;
                if(cur.right!=null&&cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }
}
