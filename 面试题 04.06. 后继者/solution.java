/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 找指定节点, 既与target比大小. 路径上, 记ans为大于target的节点中最小者
// 找不到, 或找到了, 没有右子树, 则返回ans的值
// 找到了, 则看其右子树, 最左侧的节点为ans

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return findNext(root, p.val);
    }
    
    // 找后继模板
    public TreeNode findNext(TreeNode root, int target) {
        TreeNode ans = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == target) {
                if (curr.right != null) {
                    curr = curr.right;
                    while (curr.left != null) curr = curr.left;
                    ans = curr;
                }
                break;
            }
            if (target < curr.val) {
                if (ans == null || ans.val > curr.val) ans = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }
}
