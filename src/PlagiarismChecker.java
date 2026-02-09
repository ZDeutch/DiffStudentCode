/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Zander Deutch
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     *
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        int firstLength = doc1.length();
        int secondLength = doc2.length();

        int[][] memo = new int[firstLength + 1][secondLength + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = 0;
        }

        for (int i = 0; i < memo[0].length; i++) {
            memo[0][i] = 0;
        }

        return longestSubstringHelper(doc1, doc2, memo);
    }

    public static int longestSubstringHelper(String doc1, String doc2, int[][] memo) {
        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[doc1.length()][doc2.length()];
    }
}
