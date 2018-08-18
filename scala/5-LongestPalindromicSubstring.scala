/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

https://leetcode.com/problems/longest-palindromic-substring/
*/


object Solution {
    def longestPalindrome(s: String): String = {
        
        if (s.size == 0)
            return ""
        //Adding symbols in the given String
        val transformedString = "^" + s.map(x => "#" + x).mkString + "#" + "$"
        var palindromeString = Array.fill(transformedString.size){0}
        var currentIndex = 0
        var rightBoundry = 0
        
        for(index <- 1 until transformedString.size - 1){
            var mirrorIndex = currentIndex - (index - currentIndex)
            
            palindromeString(index) = if (rightBoundry > index){
                Math.min(rightBoundry-index, palindromeString(mirrorIndex))
            }else{
                0
            }
            
            while(transformedString(index + 1 + palindromeString(index)) == transformedString(index - 1 - palindromeString(index))){
                palindromeString(index) = palindromeString(index) + 1
            }
             
            if ((index + palindromeString(index)) > rightBoundry){
                currentIndex = index
                rightBoundry = index + palindromeString(index)
            } 
        }
        val (maxVal,midOfPalindromeString) = palindromeString.zipWithIndex.max
        val longestPalindromeStartIndex = (midOfPalindromeString - 1 - maxVal)/2
        val longestPalindromeEndIndex = longestPalindromeStartIndex + maxVal
        s.slice(longestPalindromeStartIndex, longestPalindromeEndIndex)
        
    }
}
