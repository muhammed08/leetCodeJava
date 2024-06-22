/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
 */
public class WildCardMatcher {
        int[][] dp;
        boolean[] isRemStar;
        public boolean isMatch(String s, String p) {
            int l1=s.length(), l2 = p.length();
            if (l2 == 0 && l1 !=0){
                return false;
            } else if (l1==0 && l2 == 0){
                return true;
            }
            dp = new int[l1+1][l2+1];
            isRemStar = new boolean[l2];
            isRemStar[l2-1] = p.charAt(l2-1) == '*';
            for (int i=p.length()-2; i>=0; i--){
                isRemStar[i] = isRemStar[i+1] && p.charAt(i) == '*';
            }
            return patternf(s,p,0,0)==1?true:false;
        }

        public int patternf(String s, String pattern,int i, int j) {
            if (s.length() == i && (pattern.length() == j || isRemStar[j])) {
                dp[i][j] = 1;
                return 1;
            }
            if ((s.length() == i && pattern.length() != j) || (s.length() != i && pattern.length() == j)) {
                dp[i][j] = -1;
                return -1;
            }

            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            int ret;
            if (pattern.charAt(j) == '?') {
                ret = patternf(s, pattern, i + 1, j + 1);
            } else if (pattern.charAt(j) == '*') {
                ret = patternf(s, pattern, i + 1, j);
                if (ret != 1) {
                    ret = patternf(s, pattern, i + 1, j + 1);
                }
                if (ret != 1) {
                    ret = patternf(s, pattern, i, j + 1);
                }
            } else if (pattern.charAt(j) == s.charAt(i)) {
                ret = patternf(s, pattern, i + 1, j + 1);
            } else {
                ret = -1;
            }
            dp[i][j] = ret;
            return ret;
        }

    public static void main(String[] args) {
        WildCardMatcher matcher = new WildCardMatcher();
        System.out.println(matcher.isMatch("aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab", "*ab***ba**b*b*aaab*b"));
    }
}
