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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {}
        else if (key == root.val) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode next = root.right;
            while(next.left != null) next = next.left;
            root.right = deleteNode(root.right, next.val);
            root.val = next.val;
        }
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }
}
