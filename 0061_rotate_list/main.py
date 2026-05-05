from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k==0:
            return head

        # get last element and the length of the list
        length = 1
        last = head
        while last.next:
            length += 1
            last = last.next

        k = k % length
        if k == 0:
            return head

        newhead = head
        newlast = None
        for i in range(length - k):
            newlast = newhead
            newhead = newhead.next
        
        newlast.next = None
        last.next = head
        
        return newhead
    
if __name__ == "__main__":
    sol = Solution()
    test_cases = [
            ([1,2,3,4,5], 2, [4,5,1,2,3]),
            ([0,1,2], 4, [2,0,1]),
            ([1], 0, [1]),
            ([1,2], 2, [1,2])
    ]

    for head_list, k, expected_list in test_cases:
        head = ListNode(head_list[0])
        current = head
        for val in head_list[1:]:
            current.next = ListNode(val)
            current = current.next

        print(f"Input: \t\t{head_list} k={k}")
        result_head = sol.rotateRight(head, k)

        result_list = []
        while result_head:
            result_list.append(result_head.val)
            result_head = result_head.next

        print(f"Expected: \t{expected_list} \nGot: \t\t{result_list}")
        print()
        assert result_list == expected_list