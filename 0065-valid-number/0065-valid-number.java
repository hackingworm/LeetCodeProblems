class Solution {
    int getDigits(String s) {
        int i = 0;
        for (i = 0; i < s.length() && Character.isDigit(s.charAt(i)); i++);
        return i;
    }

    public boolean isNumber(String s) {
        int i = 0;

        if ('+' == s.charAt(0) || '-' == s.charAt(0)) {
            i++;
        }

        int preDot = getDigits(s.substring(i, s.length()));
        /*
        while (s.length() > i + preDot
            && Character.isDigit(s.charAt(i + preDot))) {
            preDot++;
        }
        */
        i += preDot;

        if (i == s.length()) {
            return preDot > 0;
        }

        if ('.' == s.charAt(i)) {
            i++;
        }

        int postDot = getDigits(s.substring(i, s.length()));
        /*
        while(s.length() > i + postDot
            && Character.isDigit(s.charAt(i + postDot))) {
            postDot++;
        }
        */
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

        int num = getDigits(s.substring(i, s.length()));
        /*
        while (s.length() > i + num
            && Character.isDigit(s.charAt(i + num))) {
            num++;
        }
        */

        return 0 < num && s.length() == i + num;
    }
}