class MedianFinder {
    priority_queue<int> maxHeap;
    priority_queue<int, vector<int>, greater<int>> minHeap;

public:
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.push(num);
        } else {
            maxHeap.push(num);
        }

        if (0 == minHeap.size()) {
            return;
        }

        int small = maxHeap.top();
        int large = minHeap.top();
        if (small <= large) {
            return;
        }

        maxHeap.pop();
        if (maxHeap.size() < minHeap.size()) {
            minHeap.pop();
            maxHeap.push(large);
        }
        minHeap.push(small);
    }
    
    double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.top();
        }
        
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.top();
        }

        return double(maxHeap.top() + minHeap.top()) / 2;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */