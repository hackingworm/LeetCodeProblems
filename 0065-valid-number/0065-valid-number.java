/*
+/-[0-9]*[.][0-9]*[e/E][0-9]+
*/
class Solution {
    public boolean isNumber(String s) {
        int i = 0;

        if ('+' == s.charAt(0) || '-' == s.charAt(0)) {
            i++;
        }

        int preDot = 0;
        while (s.length() > i + preDot
            && Character.isDigit(s.charAt(i + preDot))) {
            preDot++;
        }
        i += preDot;

        if (i == s.length()) {
            return preDot > 0;
        }

        if ('.' == s.charAt(i)) {
            i++;
        }

        int postDot = 0;
        while(s.length() > i + postDot
            && Character.isDigit(s.charAt(i + postDot))) {
            postDot++;
        }
        i += postDot;

        if (0 == preDot && 0 == postDot) {
            return false;
        }

        if (s.length() == i) {
            return true;
        }

        if ('e' == s.charAt(i) || 'E' == s.charAt(i)) {
            i++;
        } else {
            return false;
        }

        if (s.length() == i) {
            return false;
        }

        if ('+' == s.charAt(i) || '-' == s.charAt(i)) {
            i++;
        }

        if (s.length() == i) {
            return false;
        }

        int num = 0;
        while (s.length() > i + num
            && Character.isDigit(s.charAt(i + num))) {
            num++;
        }

        return 0 < num && s.length() == i + num;
    }
}