// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, preorder.length - 1);
    }

    TreeNode build(int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        int rootVal = preorder[l1];
        TreeNode root = new TreeNode(rootVal);
        int mid = l2;
        while(inorder[mid] != rootVal) mid++;
        // 落实到细节, 处理指针比较麻烦. 注意preorder计算长度时, 左端点也占据一个单位
        root.left = build(l1 + 1, l1 + mid - l2, l2, mid - 1);
        root.right = build(l1 + 1 + mid - l2, r1, mid + 1, r2);
        return root;
    }

    int[] preorder;
    int[] inorder;
}
