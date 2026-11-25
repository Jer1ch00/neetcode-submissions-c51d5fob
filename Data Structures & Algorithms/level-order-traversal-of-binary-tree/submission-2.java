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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        q.add(root);
        while(q.size() > 0) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }

                level.add(curr.val);
            }

            ans.add(level);
        }

        return ans;

    }
}
