class MovingAverage {
    List<Integer> queue;
    int winSize;
    int sum;

    public MovingAverage(int size) {
        winSize = size;
        sum = 0;
        queue = new ArrayList(winSize);    
    }
    
    public double next(int val) {
        if (winSize == queue.size()) {
            sum -= queue.get(0);
            queue.remove(0);
        }

        queue.add(val);
        sum += val;

        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */