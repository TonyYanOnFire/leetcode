class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 内部的类不能用 ArrayList
        ans = new ArrayList<List<Integer>>();
        chosen = new ArrayList<Integer>();
        // 不将nums和n绑定为类成员, 空间复杂度排名占比会高很多, 其实实际没省多少...
        recur(0, nums);
        return ans;
    }

    void recur(int pos, int[] nums) {
        if (pos == nums.length) {
            // 一样需要注意chosen拷贝问题. java中拷贝如下
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        recur(pos + 1, nums);
        chosen.add(nums[pos]);
        recur(pos + 1, nums);
        // ArrayList没有pop. 需要remove(n - 1)
        chosen.remove(chosen.size() - 1);
    };
    
    ArrayList<Integer> chosen;

    List<List<Integer>> ans;
}
