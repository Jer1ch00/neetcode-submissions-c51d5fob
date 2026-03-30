class Pair {
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);
        if (!st.contains(endWord)) return 0; //  FIX 2

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord, 1));

        st.remove(beginWord);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.first;
            int steps = curr.second;

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == arr[i]) continue;

                    arr[i] = ch;
                    String next = new String(arr);

                    if (st.contains(next)) {
                        st.remove(next);
                        q.add(new Pair(next, steps + 1)); // 🔴 FIX 1
                    }
                }
            }
        }
        return 0;
    }
}