class Solution {
private:
    void claimIslands(int i, int j, vector<vector<char>>& grid) {
        queue<pair<int, int>> q;
        q.push({i, j});
        while (!q.empty()) {
            pair p = q.front();
            q.pop();

            if (0 < p.first && '1' == grid[p.first - 1][p.second]) {
                grid[p.first - 1][p.second] = 'i';
                q.push({p.first - 1, p.second});
            }

            if (grid.size() - 1 > p.first && '1' == grid[p.first + 1][p.second]) {
                grid[p.first + 1][p.second] = 'i';
                q.push({p.first + 1, p.second});
            }

            if (0 < p.second && '1' == grid[p.first][p.second - 1]) {
                grid[p.first][p.second - 1] = 'i';
                q.push({p.first, p.second - 1});
            }

            if (grid[p.first].size() - 1 > p.second && '1' == grid[p.first][p.second + 1]) {
                grid[p.first][p.second + 1] = 'i';
                q.push({p.first, p.second + 1});
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