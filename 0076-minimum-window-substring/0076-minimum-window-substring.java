class Solution {
    boolean allIncluded(HashMap<Character, Integer> tmap, HashMap<Character, Integer> smap) {
        for (Map.Entry<Character, Integer> pair: tmap.entrySet()) {
            char ch = pair.getKey();
            int count = pair.getValue();
            if (!smap.containsKey(ch) || count > smap.get(ch)) {
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (tmap.containsKey(ch)) {
                tmap.replace(ch, tmap.get(ch) + 1);
            } else {
                tmap.put(ch, 1);
            }
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        boolean found = false;
        int end;
        for (end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (tmap.containsKey(ch)) {
                if (smap.containsKey(ch)) {
                    smap.replace(ch, smap.get(ch) + 1);
                } else {
                    smap.put(ch, 1);
                }

                if (0 == tmap.get(ch).compareTo(smap.get(ch))) {
                    if (allIncluded(tmap, smap)) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No found");
            return "";
        }

        int miniWBegin = 0,
            miniWEnd = end;

        int begin = 0;
        while (true) {
            while (true) {
                char ch = s.charAt(begin);
                if (smap.containsKey(ch)) {
                    if (0 == tmap.get(ch).compareTo(smap.get(ch))) {
                        break;
                    }

                    smap.replace(ch, smap.get(ch) - 1);
                }

                begin++;
            }

            if (miniWEnd - miniWBegin > end - begin) {
                miniWBegin = begin;
                miniWEnd = end;
            }

            char ch = s.charAt(begin++);
            end++;
            for (; end < s.length(); end++) {
                char ch2 = s.charAt(end);
                if (ch == ch2) {
                    break;
                }

                if (smap.containsKey(ch2)) {
                    smap.replace(ch2, smap.get(ch2) + 1);
                }
            }

            if (s.length() == end) {
                break;
            }
        }

        return s.substring(miniWBegin, miniWEnd + 1);
    }
}