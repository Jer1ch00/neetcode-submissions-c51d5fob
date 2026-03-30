/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return f(root, root.val);
    }

    private int f(TreeNode root, int maxVal) {
        if(root == null) {
            return 0;
        }
        int res = (root.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(root.val,maxVal);

        res += f(root.left,maxVal);
        res += f(root.right,maxVal);

        return res;
    }
}
