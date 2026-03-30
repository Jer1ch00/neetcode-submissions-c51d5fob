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
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.first;
            int steps = curr.second;

            if(word.equals(endWord)) {
                return steps;
            }

            for(int i=0; i<word.length(); i++) {
                char[] arr = word.toCharArray();
                for(char ch='a'; ch<='z'; ch++){
                    if(ch == arr[i]) {
                        continue;
                    }
                    arr[i] = ch;
                    String next = new String(arr);
                    if(set.contains(next)) {
                        set.remove(next);
                        q.offer(new Pair(next, steps+1));
                    }
                }
            }
        }

        return 0;
    }
}
