class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        for (int i = 0; i < edges.size(); i++) {
            int from = edges[i][0], to = edges[i][1];
            if (from > to) {
                edges[i][0] = to;
                edges[i][1] = -from;
            } else {
                edges[i][1] = -to;
            }
        }

        vector<int> counters(n, 0);
        counters[0] = 1;
        int resolved = 1;
        while (true) {
            int thisRound = 0;
            for (int i = 0; i < edges.size(); i++) {
                int from = edges[i][0], to = -edges[i][1];
                if (0 > to || 0 == counters[from] && 0 == counters[to]) {
                    continue;
                }

                if (1 == counters[from] && 1 == counters[to]) {
                    return false;
                }

                if (0 == counters[from]) {
                    counters[from] = 1;
                } else {
                    counters[to] = 1;
                }

                edges[i][1] = to;
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