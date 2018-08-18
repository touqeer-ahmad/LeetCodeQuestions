/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

https://leetcode.com/problems/reverse-integer

*/

object Solution {
    def reverse(x: Int): Int = {
        
        val isNegative = x < 0
        val (xString, intBoundry)  = isNegative match {
            case true => (x.toString.drop(1), Int.MinValue.toString.drop(1))
            case false => (x.toString, Int.MaxValue.toString)
        }
        
        val xStringReveresed = xString.reverse
        val intBoundryLength = intBoundry.size
        
        (xString.size, isNegative) match {
            case (`intBoundryLength`, _) if xStringReveresed > intBoundry => return 0
            case (_, true)   => return xStringReveresed.toInt * -1 
            case (_, _)      => return xStringReveresed.toInt
        }
    }
}

/* Another Solution
object Solution {
    def reverse(x: Int): Int = {
        
        var result: Int = 0
        var number: Int = x
        while(number != 0){
            var LSD = number % 10
            number = number /10
            
            if ((result > Int.MaxValue/10) || 
                (result < Int.MinValue/10) || 
                (result == Int.MaxValue / 10 && LSD > 7) || 
                (result == Int.MinValue / 10 && LSD < -8))
                    return 0
            result = result * 10 + LSD
        }
        result
    }
}*/
