class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] opt = new int[amount + 1];
        opt[0] = 0;
        for (int i = 1; i <= amount; i++) opt[i] = -1;
        for (int coin : coins) if (coin < amount + 1) opt[coin] = 1;

        // 0: 0, 1: 1, 2: 1, 5: 1
        // 3: 2
        // 4 (3 ? 2? ) -> 4: 2
        // 6 (5? 4? 1? )

        // 对于i, 初始设ans = -1, 考察 opt[i - coin], 取其中大于0的最小值, 结果为-1则说明opt[i] = -1
        // ans > 0 则opt[i] = ans + 1


        // 时间复杂度的增加原因出现在遍历了0 - amount的全部状态. 中间有大量是浪费的
        // 举[83, 3] 264为例. 只需要考察264 - 83和264 - 3, 中间的263 - 1都不用看
        for (int i = 1; i <= amount; i++) {
            if (opt[i] > 0) continue;

            int ans = 0;
            for (int coin : coins) {
                if (i - coin > 0 && opt[i - coin] > 0) {
                    if (ans == 0) ans = opt[i - coin];
                    else ans = Math.min(ans, opt[i - coin]);
                }
            }
            if (ans > 0) opt[i] = ans + 1;
        }

        return opt[amount];
    }
}


// // 居然还慢了???
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         // amount <= 1e4且coin >= 1, 则硬币最多取1e4, 我们用MAX=1e5标识不可能实现
//         opt = new int[amount + 1];
//         this.coins = coins;
//         return calc(amount) == MAX ? -1 : calc(amount);
//     }

//     int[] opt;
//     int MAX = (int) 1e5;
//     int[] coins;

//     int calc(int amount) {
//         if (amount == 0) return 0;
//         if (amount < 0) return MAX;
//         if (opt[amount] == 0) {
//             // 没算过, 算一下
//             int ans = MAX;
//             for (int coin : coins) ans = Math.min(ans, calc(amount - coin) + 1);
//             opt[amount] = ans;
//         }
//         return opt[amount];
//     }
// }