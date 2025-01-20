class MovingAverage {
    List<Integer> queue;
    int winSize;

    public MovingAverage(int size) {
        winSize = size;
        queue = new ArrayList(winSize);    
    }
    
    public double next(int val) {
        if (winSize == queue.size()) {
            queue.remove(0);
        }

        queue.add(val);

        double sum = 0;
        for (int i = 0; i < queue.size(); i++) {
            sum += queue.get(i);
        }

        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */