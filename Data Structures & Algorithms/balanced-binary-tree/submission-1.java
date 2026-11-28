class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = dfs(root.left);
        if(lh == -1){
            return -1;
        }
        int rh = dfs(root.right);
        if(rh == -1){
            return -1;
        }

        if (Math.abs(lh - rh) > 1){  
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}