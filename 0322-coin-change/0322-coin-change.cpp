#define DP

class Solution {
    #if defined(DP)
    int* results;

    void coinChangeInner(vector<int>& coins, int amount) {
        if (0 != results[amount- 1]) {
            return;
        }

        int least = -1;
        for (auto coin: coins) {
            int rst = amount - coin;
            if (0 == rst) {
                results[amount - 1] = 1;
                return;
            }

            if (0 < rst) {
                coinChangeInner(coins, rst);
                rst = results[rst - 1];
                if (0 < rst) {
                    rst++;
                    if (-1 == least || least > rst) {
                        least = rst;
                    }
                }
            }
        }

        results[amount - 1] = least;
    }
    #endif

public:
    int coinChange(vector<int>& coins, int amount) {
        if (0 == amount) {
            return 0;
        }

        sort(coins.begin(), coins.end());

        #if defined(DP)
        results = new int[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = 0;
        }

        coinChangeInner(coins, amount);
        #else

        int* results = new int[amount];
        for (int i = 0; i < amount; i++) {
            int rst = -1;
            for (auto coin: coins) {
                int tmp = i + 1 - coin;
                if (0 == tmp) {
                    tmp = 1;
                } else if (0 < tmp) {
                    if (-1 == results[tmp - 1]) {
                        tmp = -1;
                    } else {
                        tmp = results[tmp - 1] + 1;
                    }
                }

                if (0 < tmp && (-1 == rst || rst > tmp)) {
                    rst = tmp;
                }
            }

            results[i] = rst;
        }
        #endif

        int rst = results[amount - 1];
        delete[] results;
        return rst;
    }
};