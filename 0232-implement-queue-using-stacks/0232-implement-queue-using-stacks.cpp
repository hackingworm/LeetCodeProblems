class MyQueue {
public:
    stack<int> stacka, stackb;
    enum Op {Push, Pop};
    Op preOp;

    MyQueue() {
        preOp = Push;
    }
    
    void swap(stack<int>& src, stack<int>& dst) {
        while (!dst.empty()) {
            dst.pop();
        }

        while (!src.empty()) {
            int e = src.top();
            src.pop();
            dst.push(e);
        }
    }

    void push(int x) {
        if (Pop == preOp) {
            swap(stackb, stacka);
            preOp = Push;
        }

        stacka.push(x);
    }
    
    int pop() {
        if (Push == preOp) {
            swap(stacka, stackb);
            preOp = Pop;
        }

        int e = stackb.top();
        stackb.pop();
        return e;
    }
    
    int peek() {
        if (Push == preOp) {
            swap(stacka, stackb);
            preOp = Pop;
        }

        return stackb.top();
    }
    
    bool empty() {
        return Push == preOp? stacka.empty(): stackb.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */