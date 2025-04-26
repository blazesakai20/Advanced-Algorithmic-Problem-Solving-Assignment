class Solution {
    public int pivotIndex(int[] nums) {
        int prefixsum[] = new int[nums.length];
        int suffixsum[] = new int[nums.length];
        prefixsum[0] = nums[0];
        suffixsum[nums.length-1] = nums[nums.length-1];
        for(int i = 1 ; i<nums.length; i++){
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }
          for(int j = nums.length-2 ; j>=0; j--){
            suffixsum[j] = suffixsum[j+1] +  nums[j];
        }
        for (int i = 0; i <= nums.length-1; i++) {
            if (prefixsum[i] == suffixsum[i]) {
                return i;
            } 
        }
        return -1;
 }
}