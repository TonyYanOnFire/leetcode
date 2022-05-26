class Solution {
    public int minimumEffort(int[][] tasks) {
        // 贪心. 按照min - actual大小排序, 优先完成大的. 遍历一遍, 取max(min, ans + actual)
        // 关键在于证明这件事
        Arrays.sort(tasks, (taskA, taskB) -> taskA[1] - taskA[0] - (taskB[1] - taskB[0]));
        int ans = 0;
        for (int[] task : tasks) {
            ans = Math.max(task[1], ans + task[0]);
        }
        return ans;
    }
}
