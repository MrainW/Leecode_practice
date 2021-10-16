/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pNode = dfs(root, p.val), qNode = dfs(root, q.val);
        return (qNode == null || pNode == null) ? null : lca(root, pNode, qNode);
    }
    private TreeNode dfs(TreeNode cur, int target){
        if (cur == null) return null;
        if (cur.val == target) return cur;
        TreeNode left = dfs(cur.left, target);
        TreeNode right = dfs(cur.right, target);
        return left == null ? right : left;
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}