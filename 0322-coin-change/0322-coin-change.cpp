class Solution {
    // vector<int> coins;

public:
    /*
    int coinChange(int length, int amount) {
        int last = coins[length - 1];
        int quo = amount / last;
        int remain = amount % last;

        if (0 == remain) {
            return quo;
        }

        if (1 == length) {
            return -1;
        }

        int total = -1;
        for (;;) {
            int sub = coinChange(length - 1, remain);
            if (-1 != sub && (-1 == total || total > sub + quo)) {
                    total = quo + sub;
            }

            if (0 == quo) {
                break;
            }

            remain += last;
            quo--;
        }

        return total;
    }
    */

    int coinChange(vector<int>& coins, int amount) {
        if (0 == amount) {
            return 0;
        }

        sort(coins.begin(), coins.end());
        // this->coins = coins;
        // return coinChange(coins.size(), amount);
        int *results = new int[amount];
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

        int rst = results[amount - 1];
        delete[] results;
        return rst /* results[results.size() - 1] */;
    }
};