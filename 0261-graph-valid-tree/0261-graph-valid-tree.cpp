class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        for (int i = 0; i < edges.size(); i++) {
            int first = edges[i][0], second = edges[i][1];
            if (first > second) {
                edges[i][0] = second;
                edges[i][1] = first;
            }
        }

        vector<int> counters(n, 0);
        counters[0] = 1;
        int resolved = 1;
        while (true) {
            int thisRound = 0;
            for (int i = 0; i < edges.size(); i++) {
                int first = edges[i][0], second = edges[i][1];
                if (first > second || 0 == counters[first] && 0 == counters[second]) {
                    continue;
                }

                if (1 == counters[first] && 1 == counters[second]) {
                    return false;
                }

                if (0 == counters[first]) {
                    counters[first] = 1;
                } else {
                    counters[second] = 1;
                }

                edges[i][0] = second;
                edges[i][1] = first;
                resolved++;
                thisRound++;
            }

            if (0 == thisRound) {
                break;
            }
        }

        return n == resolved;
    }
};