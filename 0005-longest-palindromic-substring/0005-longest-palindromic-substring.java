class Solution {
    private int checkPalindrome(int left, int right, char[] s) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        int maxLen = 0, start = -1;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            int len = Math.max(checkPalindrome(i, i + 1, str), checkPalindrome(i, i, str));
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
}