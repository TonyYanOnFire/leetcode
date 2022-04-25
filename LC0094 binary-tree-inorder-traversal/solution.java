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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 共享数组seq储存答案
        // 定义递归函数, 递归左，插入中，递归右
        // 边界条件，节点为空直接返回
        seq = new ArrayList<Integer>(); // List和ArrayList应该理解为py中抽象基类和类的关系。所以声明seq可以用List，但是实例化必须使用ArrayList
        dfs(root);
        return seq;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        seq.add(root.val);
        dfs(root.right);
    };

    List<Integer> seq;
}
