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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        findSum(root, ans);
        return ans[0];
        
    }

    private int findSum(TreeNode node, int[] ans){
        if(node==null){
            return 0;
        }

        int leftSum = Math.max(0, findSum(node.left,ans)); // we dont take negative stuff so yes max of zero and left subtree
        int rightSum = Math.max(0, findSum(node.right,ans));


        ans[0] = Math.max(ans[0], leftSum+rightSum+node.val);

        return Math.max(leftSum,rightSum) + node.val;
    }
    
}