class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        this.map = map;
        n = arr1.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr1) list.add(num);
        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (a, b) -> getOrder(a) - getOrder(b));

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }

    int n;
    Map<Integer, Integer> map;

    int getOrder(int num) {
        if (map.containsKey(num)) return map.get(num);
        // 在java里, 存order比不存慢. 不知道为什么
        // int order = n + num;
        // map.put(num, order);
        return n + num;
    }
}
