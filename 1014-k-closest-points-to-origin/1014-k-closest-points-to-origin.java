class Heap {
    int size;
    int[][] array;

    int compare(int index1, int index2) {
        int[] p1 = array[index1], p2 = array[index2];
        return p2[0] * p2[0] + p2[1] * p2[1]
                    - p1[0] * p1[0] - p1[1] * p1[1];
    }

    void relocate(int index) {
        while (index < size / 2) {
            int cindex = 2 * index + 1;
            if (cindex + 1 < size && 0 < compare(cindex + 1, cindex)) {
                cindex++;
            }

            if (0 < compare(index, cindex)) {
                break;
            }

            int[] tmp = array[index];
            array[index] = array[cindex];
            array[cindex] = tmp;
            index = cindex;
        }
    }

    Heap(int[][] array) {
        size = array.length;
        this.array = array;

        for (int i = size / 2 - 1; i >= 0; i--) {
            relocate(i);
        }
    }

    int[] getTop() {
        int[] top = array[0];
        array[0] = array[size-- - 1];
        relocate(0);
        return top;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Heap heap = new Heap(points);
        int[][] closest = new int[k][];
        for (int i = 0; i < k; i++) {
            closest[i] = heap.getTop();
        }

        return closest;
    }
}