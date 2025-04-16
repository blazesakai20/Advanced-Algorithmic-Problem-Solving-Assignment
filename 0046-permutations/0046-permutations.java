class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums, 0, ans);
        return ans;
    }

    public void recursion(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> subArray = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                subArray.add(nums[i]);
            }

            ans.add(subArray);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            recursion(nums, index + 1, ans);
            swap(index, i, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}