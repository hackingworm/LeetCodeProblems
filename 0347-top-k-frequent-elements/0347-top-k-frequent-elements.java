class Solution {
    class KV<K, V extends Comparable<V>> implements Comparable<KV<K, V>> {
        K key;
        V value;

        KV(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(KV<K, V> kv) {
            return value.compareTo(kv.value);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        KV[] frequences = new KV[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            frequences[i] = new KV(e.getKey(), e.getValue());
            i++;
        }   

        Arrays.sort(frequences);

        int[] result = new int[k];
        for (i = 0; i < k; i++) {
            KV<Integer, Integer> kv = frequences[frequences.length - i - 1];
            // System.out.println(kv.key + " " + kv.value);
            result[i] = kv.key;
        }

        return result;
    }
}