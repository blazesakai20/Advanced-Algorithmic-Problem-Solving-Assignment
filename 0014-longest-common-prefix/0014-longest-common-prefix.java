class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // Check if the current prefix is a prefix of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, return ""
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}