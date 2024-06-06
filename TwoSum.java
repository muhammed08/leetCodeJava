"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
"""
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> listMap = new HashMap();

        for (int i=0;i< nums.length; i++){
            listMap.put(nums[i], i);
        }
        int[] result = new int[2];

        for(int i=0;i< nums.length; i++){
            Integer index = listMap.get(target -nums[i]);
            if ( index != null && index != i) {
                result[0]=i;
                result[1]=index;
                return result;
            }
        }
        return result;

    }
}