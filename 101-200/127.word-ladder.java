import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    private Set<String> wordSet;
    private int level = 0;

    private void buildConnections(Set<String> begin, Set<String> end) {
        level++;
        if (begin.isEmpty()) {
            level = 0;
            return;
        }

        wordSet.removeAll(begin);
        Set<String> nextLevel = new HashSet<>();

        for (String word : begin) {
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char prev = wordChars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == prev) {
                        continue;
                    }

                    wordChars[i] = c;
                    String linkedWord = String.valueOf(wordChars);

                    if (wordSet.contains(linkedWord)) {
                        if (end.contains(linkedWord)) {
                            return;
                        } else {
                            nextLevel.add(linkedWord);
                        }
                    }
                }

                wordChars[i] = prev;
            }
        }

        if (nextLevel.size() > end.size()) {
            buildConnections(end, nextLevel);
        } else {
            buildConnections(nextLevel, end);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return level;
        }

        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        level++;
        buildConnections(begin, end);

        return level;
    }
}
// @lc code=end

