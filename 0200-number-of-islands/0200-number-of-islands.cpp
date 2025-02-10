class Solution {
    void enQueue(int i, int j, vector<vector<char>>& grid, queue<pair<int, int>>& q) {
        grid[i][j] = 'i';
        pair p(i, j);
        q.push(p);
    }

    void claimIslands(int i, int j, vector<vector<char>>& grid) {
        // queue<pair<int, int>> q;
        queue<array<int, 2>> q;
        // pair<int, int> p(i, j);
        // q.push(p);
        q.push({i, j});
        while (!q.empty()) {
            // pair p = q.front();
            array<int, 2> p = q.front();
            q.pop();

            /*
            if (0 < p.first && '1' == grid[p.first - 1][p.second]) {
                enQueue(p.first - 1, p.second, grid, q);
            }

            if (grid.size() - 1 > p.first && '1' == grid[p.first + 1][p.second]) {
                enQueue(p.first + 1, p.second, grid, q);
            }

            if (0 < p.second && '1' == grid[p.first][p.second - 1]) {
                enQueue(p.first, p.second - 1, grid, q);
            }

            if (grid[p.first].size() - 1 > p.second && '1' == grid[p.first][p.second + 1]) {
                enQueue(p.first, p.second + 1, grid, q);
            }
            */

            if (0 < p[0] && '1' == grid[p[0] - 1][p[1]]) {
                // enQueue(p[0] - 1, p[1], grid, q);
                grid[p[0] - 1][p[1]] = 'i';
                q.push({p[0] - 1, p[1]});
            }

            if (grid.size() - 1 > p[0] && '1' == grid[p[0] + 1][p[1]]) {
                // enQueue(p[0] + 1, p[1], grid, q);
                grid[p[0] + 1][p[1]] = 'i';
                q.push({p[0] + 1, p[1]});
            }

            if (0 < p[1] && '1' == grid[p[0]][p[1] - 1]) {
                // enQueue(p[0], p[1] - 1, grid, q);
                grid[p[0]][p[1] - 1] = 'i';
                q.push({p[0], p[1] - 1});
            }

            if (grid[p[0]].size() - 1 > p[1] && '1' == grid[p[0]][p[1] + 1]) {
                // enQueue(p[0], p[1] + 1, grid, q);
                grid[p[0]][p[1] + 1] = 'i';
                q.push({p[0], p[1] + 1});
            }
        }
    }

public:
    int numIslands(vector<vector<char>>& grid) {
        int num = 0;
        for (int i = 0; grid.size() > i; i++) {
            for (int j = 0; grid[i].size() > j; j++) {
                if ('1' == grid[i][j]) {
                    grid[i][j] = 'i';
                    claimIslands(i, j, grid);
                    num++;
                }
            }
        }

        return num;
    }
};