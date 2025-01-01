class Solution {
    public int subarraySum(int[] nums, int k) {
        int sums[] = new int[nums.length + 1]; 
        sums[0] = 0;
        for (int sum = 0, i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }

        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        for (int i = 1; i < sums.length; i++) {
            if (sumMap.containsKey(sums[i])) {
                List<Integer> list = sumMap.get(sums[i]);
                list.add(i);
                Collections.sort(list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                sumMap.put(sums[i], list);
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            /*
            for (int j = i + 1; j < nums.length + 1; j++) {
                if (k == sums[j] - sums[i]) {
                    count++;
                }
            }
            */

            int key = k + sums[i];
            if (sumMap.containsKey(key)) {
                List<Integer> list = sumMap.get(key);
                int begin = 0,
                    end = list.size(),
                    middle = 0;
                while (begin < end) {
                    middle = (begin + end) >> 1;
                    if (i < list.get(middle)) {
                        end = middle - 1;
                    } else {
                        begin = middle + 1;
                    }
                }

                if (begin < list.size() && i >= list.get(begin)) {
                    begin++;
                }

                count += list.size() - begin;
            }
        }

        return count;
    }
}