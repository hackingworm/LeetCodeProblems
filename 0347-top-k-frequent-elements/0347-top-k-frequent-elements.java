class Solution {
    public HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hMap) {
        List<Map.Entry<Integer, Integer>> list
            = new LinkedList<Map.Entry<Integer, Integer>>(hMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> item1, Map.Entry<Integer, Integer> item2) {
                return (item2.getValue()) - (item1.getValue());

            }
        });

        HashMap<Integer, Integer> linked = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> item: list) {
            linked.put(item.getKey(), item.getValue());
        }

        return linked;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        for (int i: nums) {
            Integer value = freqs.get(i);
            if (null == value) {
                freqs.put(i, 1);
            } else {
                freqs.put(i, value + 1);
            }
        }
        // System.out.println(freqs);

        Map<Integer, Integer> linked = sortByValue(freqs);
        // System.out.println(linked);

        int[] results = new int[k];
        int i = 0;
        for (Integer key: linked.keySet()) {
            results[i++] = key;
            if (k == i) {
                break;
            }
        }

        return results;
    }
}