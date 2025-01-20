class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (0 == firstList.length || 0 == secondList.length) {
            return new int[0][];
        }

        List<int[]> intersecs = new ArrayList();
        for (int fi = 0, si = 0; fi < firstList.length && si < secondList.length;) {
            int[] first, second;
            if (firstList[fi][0] <= secondList[si][0]) {
                first = firstList[fi];
                second = secondList[si];
            } else {
                first = secondList[si];
                second = firstList[fi];
            }
            
            if (first[1] < second[0]) {
                if (firstList[fi] == first) {
                    fi++;
                } else {
                    si++;
                }

                continue;
            }

            first[0] = second[0];

            if (first[1] > second[1]) {
                intersecs.add(new int[]{first[0], second[1]});
                first[0] = second[1] + 1;
            } else {
                if (first[1] < second[1]) {
                    second[0] = first[1] + 1;
                    if (firstList[fi] == first) {
                        fi++;
                    } else {
                        si++;
                    }
                } else {
                    fi++;
                    si++;
                }

                intersecs.add(first);
            }
        }

        return intersecs.toArray(new int[intersecs.size()][]);
    }
}