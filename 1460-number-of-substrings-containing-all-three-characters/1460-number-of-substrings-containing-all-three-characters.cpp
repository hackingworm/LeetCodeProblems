class Solution {
public:
    int numberOfSubstrings(string s) {
        int num = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            bool a = false, b = false, c = false;
            int j;
            for (j = i; j < s.length() && (!a || !b || !c); j++) {
                a |= 'a' == s[j];
                b |= 'b' == s[j];
                c |= 'c' == s[j];
            }

            if (a && b && c) {
                num += s.length() - j + 1;
            }
        }
        
        return num;
    }
};