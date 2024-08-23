class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        for (int i: nums) {
            Integer value = freqs.get(i);
            if (null == value) {
                freqs.put(i, 1);
            } else {
                freqs.put(i, value + 1);
            }
        }
        // System.out.println(freqs);

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(freqs.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> item1, Map.Entry<Integer, Integer> item2) {
                return item2.getValue() - item1.getValue();
            }
        });

        int[] results = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> item: list) {
            results[i++] = item.getKey();
            if (k == i) {
                break;
            }
        }

        return results;
    }
}