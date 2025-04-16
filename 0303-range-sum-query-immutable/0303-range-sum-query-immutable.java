class NumArray {
    private int prefixSum[];
    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        this.prefixSum=nums;
    }
    
    public int sumRange(int left, int right) {
        if(left==0)
        return prefixSum[right];
    return (prefixSum[right]-prefixSum[left-1]);
    }
}

