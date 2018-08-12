/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

https://leetcode.com/problems/add-two-numbers/description/
*/
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var solutionList = ListNode(0)
        var helperList = solutionList
        var l1Helper = l1
        var l2Helper = l2
        var carry = 0
        var temp = 0
        
        while(l1Helper != null && l2Helper != null){
            temp = l1Helper.x + l2Helper.x
            
            val total = temp + carry
            
            if (total <= 9){
                helperList.next = ListNode(total)
                carry = 0
            }else {
                helperList.next = ListNode(total % 10)
                carry = 1
            }
            
            l1Helper = l1Helper.next
            l2Helper = l2Helper.next
            
            helperList = helperList.next
        }
        
        while(l1Helper != null){ 
            val total = l1Helper.x + carry
            
            if (total <= 9){
                helperList.next = ListNode(total)
                carry = 0
            }else {
                helperList.next = ListNode(total % 10)
                carry = 1
            }
            
            l1Helper = l1Helper.next
            helperList = helperList.next
        }
        
        while(l2Helper != null){ 
            val total = l2Helper.x + carry
            
            if (total <= 9){
                helperList.next = ListNode(total)
                carry = 0
            }else {
                helperList.next = ListNode(total % 10)
                carry = 1
            }
            
            l2Helper = l2Helper.next
            helperList = helperList.next
        }
        
        if (carry == 1){
            helperList.next = ListNode(1)
            helperList = helperList.next
        }
        solutionList.next
    }
}
