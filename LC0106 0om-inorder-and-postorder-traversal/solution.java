// https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, postorder.length - 1, 0, inorder.length - 1);
    }

    // l1, r1为postorder范围, l2, r2 为inorder范围
    TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1) return null;
        int rootVal = postorder[r1];
        TreeNode root = new TreeNode(rootVal);
        int mid = l2;
        while(inorder[mid] != rootVal) mid++;
        // l1 + (mid - 1 - l2 + 1) - 1
        root.left = build(l1, l1 + mid - l2 - 1, l2, mid - 1);
        root.right = build(l1 + mid - l2, r1 - 1, mid + 1, r2);
        return root;
    }

    int[] inorder;
    int[] postorder;
}
