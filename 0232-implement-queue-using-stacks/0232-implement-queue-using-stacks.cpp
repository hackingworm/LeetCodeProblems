class MyQueue {
public:
    stack<int> stacka, stackb;

    void push(int x) {
        stacka.push(x);
    }
    
    int pop() {
        if (stackb.empty()) {
            while (!stacka.empty()) {
                int e = stacka.top();
                stacka.pop();
                stackb.push(e);
            }
        }

        int e = stackb.top();
        stackb.pop();
        return e;
    }
    
    int peek() {
        if (stackb.empty()) {
            while (!stacka.empty()) {
                int e = stacka.top();
                stacka.pop();
                stackb.push(e);
            }
        }

        return stackb.top();
    }
    
    bool empty() {
        return stacka.empty() && stackb.empty();
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