import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private int muldiv(String s) {
        Pattern pattern = Pattern.compile("[\\*\\/]");
        Matcher matcher = pattern.matcher(s);

        int product = 1;
        int last = 0;
        char op = '*';
        while (matcher.find()) {
            int start = matcher.start(),
                end = matcher.end();

            int num = Integer.parseInt(s.substring(last, start).trim());
            if ('*' == op) {
                product *= num;
            } else {
                product /= num;
            }

            last = end;
            op = s.charAt(start);
        }

        int num = Integer.parseInt(s.substring(last, s.length()).trim());
        if ('*' ==op) {
            product *= num;
        } else {
            product /= num;
        }

        return product;
    }

    public int calculate(String s) {
        int sum = 0;
        int from = 0;
        char op = '+';
        while (true) {
            int plus = s.indexOf('+', from),
                minus = s.indexOf('-', from);

            if (-1 == plus && -1 == minus) {
                    break;
            }

            int to = -1 == minus || -1 != plus && minus > plus? plus: minus;

            int num = muldiv(s.substring(from, to).trim());
            sum += '+' == op? num: -num;
            from = to + 1;
            op = s.charAt(to);
        }

        int num = muldiv(s.substring(from));
        sum += '+' == op? num: -num;

        return sum;
    }
}