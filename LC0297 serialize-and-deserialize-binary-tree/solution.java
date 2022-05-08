// https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        record(root);
        String ans = String.join(",", seq);
        seq = new ArrayList<String> ();
        return ans;
    }

    void record (TreeNode node) {
        if (node == null) {
            seq.add("null");
            return;
        }
        seq.add(Integer.toString(node.val));
        record(node.left);
        record(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        seq = Arrays.asList(data.split(","));
        curr = 0;
        TreeNode root = build();
        seq = new ArrayList<String> ();
        return root;
    }

    TreeNode build () {
        if (seq.get(curr).equals("null")) {
            curr++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(seq.get(curr)));
        curr++;
        node.left = build();
        node.right = build();
        return node;
    }

    List<String> seq = new ArrayList<String> ();
    int curr;
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


// array转换为list：Arrays.asList(myArr)
// build函数看起来挺神奇, 仔细一想确实也符合逻辑