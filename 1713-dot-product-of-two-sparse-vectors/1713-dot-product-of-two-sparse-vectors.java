class SparseVector {
    List<Pair<Integer, Integer>> nonZeros = new ArrayList<>();
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                nonZeros.add(new Pair<>(i, nums[i]));
            }
        }
        
    }
    
    public List<Pair<Integer, Integer>> getNonZeros() {
        return nonZeros;
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        List<Pair<Integer, Integer>> nonZeros2 = vec.getNonZeros();
        for (int j = 0, i = 0; j < nonZeros2.size() && i < nonZeros.size(); i++) {
            Pair<Integer, Integer> nonZero = nonZeros.get(i);
            int index = nonZero.getKey();
            for (; j < nonZeros2.size(); j++) {
                Pair<Integer, Integer> nonZero2 = nonZeros2.get(j);
                int index2 = nonZero2.getKey();

                if (index <= index2) {
                    if (index == index2) {
                        product += nonZero.getValue() * nonZero2.getValue();
                    }

                    break;
                }
            }
        }

        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);