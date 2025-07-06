# Leetcode Problem 2: Add Two Numbers
# This code defines a ListNode class for singly-linked lists and a Solution class with a method to add two numbers represented by linked lists.

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def print(self):
        current = self
        result = []
        while current:
            result.append(current.val)
            current = current.next
        return " -> ".join(map(str, result))
    
class Solution(object):
    def addTwoNumbersRecursive(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        return self._add(l1, l2, 0)

    def _add(self, l1, l2, carry):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :type carry: Int
        """
        if not l1 and not l2 and not carry:
            return None

        val1 = l1.val if l1 else 0
        val2 = l2.val if l2 else 0
        carry, digit = divmod(carry + val1 + val2, 10)
        
        result = ListNode(digit)
        result.next = self._add(
                    l1.next if l1 else None, 
                    l2.next if l2 else None, 
                    carry)

        return result
            
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        result = ListNode()
        current = result
        carry = 0
        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            
            carry, digit = divmod(carry + val1 + val2, 10)
            current.next = ListNode(digit)
            current = current.next

            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
                
        return result.next



def main():
    # Create first number: 2 -> 4 -> 9 (represents 942)
    l1 = ListNode(2, ListNode(4, ListNode(9)))
    # Create second number: 5 -> 6 -> 4 -> 9 (represents 9465)
    l2 = ListNode(5, ListNode(6, ListNode(4, ListNode(9))))
    sol = Solution()
    result = sol.addTwoNumbers(l1, l2)
    # Print result as a list
    print(result.print())  # Expected output: 7 -> 0 -> 4 -> 0 -> 1 (represents 10407)

if __name__ == "__main__":
    main()
