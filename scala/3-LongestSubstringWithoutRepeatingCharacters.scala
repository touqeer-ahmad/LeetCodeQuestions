/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var solution = 0
        var indexHelper = Map[Char, Int]() //to keep track of the last seen index of repeating characters
        var temp = 0
        
        for((char, index) <- s.zipWithIndex){
            if(indexHelper contains char){
                temp = Math.max(indexHelper(char), temp)
            }
            solution = Math.max(solution, index - temp + 1)
            indexHelper += (char -> (index + 1))
        }
        solution
    }
}
