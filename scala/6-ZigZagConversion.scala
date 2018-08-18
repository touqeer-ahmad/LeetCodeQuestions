/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

https://leetcode.com/problems/zigzag-conversion
*/

object Solution {
    def convert(s: String, numRows: Int): String = {

        if (s.size == 1 || numRows == 1){
            return s
        }

        val finalArraySize = Math.min(numRows, s.size)
        val finalArray = Array.fill(finalArraySize){""}

        var dirFlag = false
        var rowNum = 0

        for(char <- s){
            finalArray(rowNum) = finalArray(rowNum) + char
            if( rowNum == 0 || rowNum == numRows -1){
                dirFlag = !dirFlag
            }
            rowNum = dirFlag match {
                case true  => { rowNum + 1 }
                case false => { rowNum - 1 }
            }
        }
        finalArray.mkString("")
    }
}
