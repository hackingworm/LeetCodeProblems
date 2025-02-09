class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        sort(prerequisites.begin(), prerequisites.end());
        /* 
        for (auto prerequisite: prerequisites) {
            cout << '[' << prerequisite[0] << ',' << prerequisite[1] << "] ";
        }
        cout << endl;
        */

        bool erased = true;
        while (erased) {
            erased = false;
            for (int i = 0; prerequisites.size() > i; i++) {
                int required = prerequisites[i][1];
                int j = 0, k = prerequisites.size();
                while (j < k) {
                    int m = (j + k) / 2;
                    if (required == prerequisites[m][0]) {
                        break;
                    }

                    if (required < prerequisites[m][0]) {
                        k = m;
                    } else {
                        j = m + 1;
                    }
                }

                if (j >= k) {
                    prerequisites.erase(prerequisites.begin() + i);
                    erased = true;
                }
            }
        }

        return 0 == prerequisites.size();
    }
};