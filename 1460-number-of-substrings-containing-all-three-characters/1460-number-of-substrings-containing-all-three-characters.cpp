class Solution {
public:
    int numberOfSubstrings(string s) {
        int num = 0;
        int begin = 0, last = 0;
        int ai = -1, bi = -1, ci = -1;

        for (;;) {
            int sub = 0;
            for (int i = last; i < s.length(); i++) {
                if ('a' == s[i]) {
                    ai = i;
                } else if ('b' == s[i]) {
                    bi = i;
                } else if ('c' == s[i]) {
                    ci = i;
                }

                if (!(-1 == ai || -1 == bi || -1 == ci)) {
                    int first = min(min(ai, bi), ci);
                    last = max(max(ai, bi), ci);
                    sub = (first - begin + 1) * (s.length() - last);

                    if (ai == first) {
                        ai = -1;
                    } else if (bi == first) {
                        bi = -1;
                    } else {
                        ci = -1;
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
        
        return num;
    }
};