class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character,Integer> map=new HashMap<>();
        int i=0,j=0,l=0,maxlength=0;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))>=i){
                 i = map.get(s.charAt(j)) + 1;
            }
            maxlength=Math.max(j-i+1,maxlength);
                map.put(s.charAt(j),j);
               j++;
            
        }
        return maxlength;
    }
}