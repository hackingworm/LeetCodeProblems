class Solution {
    public String simplifyPath(String path) {
        String
            curDir = ".",
            parDir = "..";

        Stack <String> elementStack = new Stack<>();

        while (0 < path.length()) {
            int index = 0;
            while (path.length() > index && '/' == path.charAt(index)) {
                index++;
            }

            if (path.length() == index) {
                break;
            }

            path = path.substring(index);
            index = path.indexOf('/');
            if (-1 == index) {
                index = path.length();
            }

            String element = path.substring(0, index);
            path = path.substring(index);

            if (curDir.equals(element)) {
                continue;
            }

            if (parDir.equals(element)) {
                if (!elementStack.empty()) {
                    elementStack.pop();
                }

                continue;
            }

            // System.out.println("Here: " + element);
            elementStack.push(element);
        }

        if (elementStack.empty()) {
            return "/";
        }

        Stack<String> reversed = new Stack<>();
        while (!elementStack.empty()) {
            reversed.push(elementStack.pop());
        }

        String simplePath = "";
        while (!reversed.empty()) {
            // System.out.println(reversed.peek());
            simplePath += '/' + reversed.pop();
        }
        
        return simplePath;
    }
}