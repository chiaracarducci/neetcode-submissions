class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        for(int idx=0; idx<nums.length;idx++){
            int diff = target - nums[idx];
            if (set.containsKey(diff))
                return new int[]{set.get(diff), idx};
            set.put(nums[idx], idx);
        }
        return new int[0];
    }
}
