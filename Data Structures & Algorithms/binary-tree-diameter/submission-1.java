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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[1];
        dia[0] = 0;
        f(root,dia);
        return dia[0];
    }
    private int f(TreeNode root, int[] dia) {
        if(root == null) {
            return 0;
        }
        int lh = f(root.left, dia);
        int rh = f(root.right, dia);

        dia[0] = Math.max(dia[0], lh+rh);

        return 1 + Math.max(lh,rh);
    }
}
