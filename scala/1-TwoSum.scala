/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

https://leetcode.com/problems/two-sum/
*/
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map = Map[Int, Int]()
        
        for(numIndex <- 0 to nums.size-1){
            val toTarget = target - nums(numIndex)
            if(map contains nums(numIndex)){
                return Array(map(nums(numIndex)), numIndex)
            }
            map += toTarget -> numIndex
         }
        return Array()
    }
}
