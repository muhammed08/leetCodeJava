/*
Longest palindromic substring:
Approach: Using dynamic programming
 */
public class LongestPalindromeSubString {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int n=s.length();

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int maxlen =1;
        int si = 0;
        for (int i=0;i<n-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                maxlen=2;
                si=i;
            }
        }

        for (int k=3;k<= n;k++){
            for(int i=0;i<n-k+1; i++){
                int j=i+k-1;
                if (s.charAt(i)== s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    if (k> maxlen) {
                        maxlen=k;
                        si=i;
                    }
                }
            }
        }
        return s.substring(si,si+maxlen);
    }
}
