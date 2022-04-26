/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            // 逆序遍历边界条件为 i >= 0
            for (int i = node.children.size() - 1; i >= 0; i--) {
                // 索引访问不能用中括号, 而是.get(i)
                stack.push(node.children.get(i));
            }
        }
        return ans;
    }
}
