import java.util.*;

public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int concatLen = wordLen * words.length;
        int sLen = s.length();

        // Count the frequency of each word in 'words'
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Slide the window over possible starting positions
        for (int i = 0; i < wordLen; i++) {
            int start = i;
            int end = i;
            Map<String, Integer> windowCount = new HashMap<>();
            int matchedWords = 0;

            while (end + wordLen <= sLen) {
                // Extract the current word
                String word = s.substring(end, end + wordLen);
                end += wordLen;

                // If it's a valid word, update the window count
                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    if (windowCount.get(word).equals(wordCount.get(word))) {
                        matchedWords++;
                    }

                    // If the window is too large, remove the leftmost word
                    while (end - start > concatLen) {
                        String leftWord = s.substring(start, start + wordLen);
                        start += wordLen;
                        if (windowCount.containsKey(leftWord)) {
                            if (windowCount.get(leftWord).equals(wordCount.get(leftWord))) {
                                matchedWords--;
                            }
                            windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        }
                    }

                    // Check if we have a match
                    if (matchedWords == wordCount.size()) {
                        result.add(start);
                    }
                } else {
                    // Invalid word, reset the window
                    windowCount.clear();
                    matchedWords = 0;
                    start = end;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenation solution = new SubstringWithConcatenation();
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" })); // [0, 9]
        System.out.println(
                solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" })); // []
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" })); // [6,
                                                                                                                      // 9,
                                                                                                                      // 12]
    }
}
