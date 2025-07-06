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
    # 8ms | Beats 55.33%
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        result = ListNode()
        resnext = result
        l1cur = l1
        l2cur = l2
        carryover = 0
        while True:
            # non empty, so always has something in it
            x = carryover + l1cur.val + l2cur.val
            if x > 9:
                carryover = 1
                x -= 10
            else:
                carryover = 0
            resnext.val = x
            resnext.next = ListNode()
            if l1cur.next is None and l2cur.next is None:
                if carryover:
                    resnext.next.val = carryover
                else:
                    resnext.next = None
                break
            resnext = resnext.next
            if l1cur.next is not None:
                l1cur = l1cur.next
            else: 
                l1cur = ListNode(0)
            if l2cur.next is not None:
                l2cur = l2cur.next
            else: 
                l2cur = ListNode(0)
                
        return result



def main():
    # Create first number: 2 -> 4 -> 9 (represents 942)
    l2 = ListNode(2, ListNode(4, ListNode(9)))
    # Create second number: 5 -> 6 -> 4 -> 9 (represents 9465)
    l1 = ListNode(5, ListNode(6, ListNode(4, ListNode(9))))
    sol = Solution()
    result = sol.addTwoNumbers(l1, l2)
    # Print result as a list
    print(result.print())  # Expected output: 7 -> 0 -> 4 -> 0 -> 1 (represents 10407)

if __name__ == "__main__":
    main()
