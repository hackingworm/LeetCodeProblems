class Solution {
    /*
    private int muldiv(String s) {
        int product = 1;
        int from = 0;
        char op = '*';
        while (true) {
            int mul = s.indexOf('*', from),
                div = s.indexOf('/', from);

            if (-1 == mul && -1 == div) {
                break;
            }

            int to = -1 == div || -1 != mul && div > mul? mul: div;
            int value = Integer.parseInt(s.substring(from, to).trim());
            if ('*' == op) {
                product *= value;
            } else {
                product /= value;
            }

            from = to + 1;
            op = s.charAt(to);
        }

        int value = Integer.parseInt(s.substring(from).trim());
        if ('*' ==op) {
            product *= value;
        } else {
            product /= value;
        }

        return product;
    }
    */

    public int calculate(String s) {
        /*
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
            int value = muldiv(s.substring(from, to).trim());
            sum += '+' == op? value: -value;
            from = to + 1;
            op = s.charAt(to);
        }

        int value = muldiv(s.substring(from).trim());
        sum += '+' == op? value: -value;

        return sum;
        */

        Stack<Integer> operands = new Stack<>();

        char operator = '+';
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if ('0' <= ch && '9' >= ch) {
                int j = i + 1;
                while (j < s.length()) {
                    ch = s.charAt(j);
                    if ('0' > ch || '9' < ch) {
                        break;
                    }

                    j++;
                }

                int num = Integer.parseInt(s.substring(i, j));
                if ('+' == operator) {
                    operands.push(num);
                } else if ('-' == operator) {
                    operands.push(-num);
                } else if ('*' == operator) {
                    operands.push(operands.pop() * num);
                } else {
                    // Now, operator must be '/'.
                    operands.push(operands.pop() / num);
                }

                i = j;
                continue;
            }

            if ('+' == ch || '-' == ch || '*' == ch || '/' == ch) {
                operator = ch;
            }

            i++;
        }

        int sum = 0;
        while (!operands.empty()) {
            sum += operands.pop();
        }

        return sum;
    }
}