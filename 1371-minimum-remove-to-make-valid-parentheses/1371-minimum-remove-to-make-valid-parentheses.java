class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indices = new Stack<>();
        int index = 0;
        while (s.length() > index) {
            char ch = s.charAt(index);
            if ('(' == ch) {
                indices.push(index);
                index++;
                continue;
            }

            if (')' == ch) {
                if (!indices.empty()) {
                    indices.pop();
                    index++;
                    continue;
                }
                
                s = s.substring(0, index) + s.substring(index + 1);
                continue;
            }

            index++;
        }

        while (!indices.empty()) {
            index = indices.pop();
            s = s.substring(0, index) + s.substring(index + 1);
        }

        return s;
    }
}