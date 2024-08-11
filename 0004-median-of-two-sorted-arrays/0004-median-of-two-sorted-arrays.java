class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median = 0;
        int middle = (nums1.length + nums2.length + 1) >> 1;
        int i = 0, j = 0;
    
        for (int k = 0; k < middle; k++) {
            if (nums1.length == i) {
                median = nums2[j++];
            } else if (nums2.length == j) {
                median = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                median = nums2[j++];
            } else {
                median = nums1[i++];
            }
        }

        System.out.println(middle + ", " + i + ", " + j + ", " + median);

        if (middle < (nums1.length + nums2.length + 2) >>1) {
            int peer;
            if (nums1.length == i) {
                peer = nums2[j];
            } else if (nums2.length == j) {
                peer = nums1[i];
            } else if (nums1[i] > nums2[j]) {
                peer = nums2[j];
            } else {
                peer = nums1[i];
            }

            System.out.println(((nums1.length + nums2.length + 2) >> 1) + ", " + peer);

            return (double)(median + peer) / 2;
        } else {
            return median;
        }
    }
}