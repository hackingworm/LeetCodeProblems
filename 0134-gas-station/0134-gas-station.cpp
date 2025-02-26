class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int maxDeficit = 0;
        int peak = -1;
        int deficit = 0;
        for (int i = 0; i < gas.size(); i++) {
            deficit += cost[i] - gas[i];
            if (maxDeficit < deficit) {
                maxDeficit = deficit;
                peak = i;
            }
        }

        if (0 < deficit) {
            return -1;
        }

        if (gas.size() - 1 == peak) {
            return 0;
        }

        return peak + 1;
    }
};