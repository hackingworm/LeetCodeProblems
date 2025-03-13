#define ORIGIMPL 1

class Solution {
public:
    int numberOfSubstrings(string s) {
        int num = 0;
        #if ORIGIMPL
        int begin = 0, last = 0;
        vector<int> idx(3, -1);

        for (;;) {
            int sub = 0;
            for (int i = last; i < s.length(); i++) {
                idx[s[i] - 'a'] = i;

                if (!(-1 == idx[0] || -1 == idx[1] || -1 == idx[2])) {
                    int first = min(min(idx[0], idx[1]), idx[2]);
                    last = max(max(idx[0], idx[1]), idx[2]);
                    sub = (first - begin + 1) * (s.length() - last);

                    for (int j = 0; j < idx.size(); j++) {
                        if (first == idx[j]) {
                            idx[j] = -1;
                        }
                    }

                    begin = first + 1;
                    last++;
                    break;
                }
            }

            if (0 == sub) {
                break;
            }

            num += sub;
        }

        #else
        int from = 0;
        vector<int> counts(3, 0);
        for (auto c : s) {
            counts[c - 'a']++;
            while (0 < counts[0] && 0 < counts[1] && 0 < counts[2]) {
                counts[s[from++] - 'a']--;    
            }

            num += from;
        }

        #endif
        return num;
    }
};