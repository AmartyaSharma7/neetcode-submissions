class Solution {
     private int[] toposort(int n, List<List<Integer>> adj, Set<Character> set) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (char c : set) {
            int node = c - 'a';
            if (indegree[node] == 0) {
                q.offer(node);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ls.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return ls.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public String foreignDictionary(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }

       int n = 26;
       for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int n1 = word1.length();
            int n2 = word2.length();

            boolean foundDifference = false;
            for (int m = 0; m < Math.min(n1, n2); m++) {
                char c1 = word1.charAt(m);
                char c2 = word2.charAt(m);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    foundDifference = true;
                    break;
                }
            }
            if (!foundDifference && n1 > n2) {
                return "";
            }
        }

        int[] arr = toposort(n, adj, set);

        if (arr.length != set.size()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int node : arr) {
            sb.append((char) ('a' + node));
        }
        return sb.toString();
    }
}
