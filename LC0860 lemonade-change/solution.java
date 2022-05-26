class Solution {
    public boolean lemonadeChange(int[] bills) {
        coins = new HashMap<Integer, Integer>();
        for (int coin : coinValues) coins.put(coin, 0);
        for (int bill : bills) {
            coins.put(bill, coins.get(bill) + 1);
            if (!exchange(bill - 5)) return false;
        }
        return true;
    }

    Map<Integer, Integer> coins;
    int[] coinValues = {20, 10, 5};

    boolean exchange(int amount) {
        for (int coin : coinValues) {
            while (amount >= coin && coins.get(coin) > 0) {
                amount -= coin;
                coins.put(coin, coins.get(coin) - 1);
            }
        }
        return amount == 0;
    }
}
