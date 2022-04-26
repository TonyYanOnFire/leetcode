class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) return ans;
        Queue<Pair<Node, Integer>> q = new LinkedList<Pair<Node, Integer>>();
        q.add(new Pair<Node, Integer>(root, 0));
        while (!q.isEmpty()) {
            Node node = q.peek().getKey();
            Integer depth = q.poll().getValue();
            if (depth == ans.size()) ans.add(new ArrayList<Integer>());
            ans.get(depth).add(node.val);
            for (Node child: node.children) {
                q.add(new Pair<Node, Integer>(child, depth + 1));
            }
        }
        return ans;
    }
}

// 官方题解的思路一样, 但是会快很多. 接口原因?
