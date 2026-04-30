import unittest
from main import ListNode, Solution
import random

class LinkedListTestBase(unittest.TestCase):
    def list_to_linked(self, lst):
        dummy = ListNode(0)
        current = dummy
        for num in lst:
            current.next = ListNode(num)
            current = current.next
        return dummy.next

    def linked_to_list(self, node):
        result = []
        while node:
            result.append(node.val)
            node = node.next
        return result
    
    def generate_random_linked_list(self, max_len=100, max_digit=9):
        length = random.randint(1, max_len)
        
        # Ensure no leading zero in the *last* digit (i.e., highest place value)
        values = [random.randint(0, max_digit) for _ in range(length)]
        while values[-1] == 0 and length > 1:
            values[-1] = random.randint(1, max_digit)
        
        return self.list_to_linked(values), values
    def add_lists_as_ints(self, l1_vals, l2_vals):
        n1 = int(''.join(map(str, reversed(l1_vals))))
        n2 = int(''.join(map(str, reversed(l2_vals))))
        total = n1 + n2
        return [int(d) for d in str(total)][::-1]
    
class TestAddTwoNumbers(LinkedListTestBase):
    def test_iterative(self):
        sol = Solution()
        test_cases = [
            ([2, 4, 3], [5, 6, 4], [7, 0, 8]),
            ([0], [0], [0]),
            ([9, 9, 9, 9, 9, 9, 9], [9, 9, 9, 9], [8, 9, 9, 9, 0, 0, 0, 1]),
            ([2, 4, 9], [5, 6, 4, 9], [7, 0, 4, 0, 1]),
        ]
        for l1_vals, l2_vals, expected in test_cases:
            l1 = self.list_to_linked(l1_vals)
            l2 = self.list_to_linked(l2_vals)
            result = sol.addTwoNumbers(l1, l2)
            self.assertEqual(self.linked_to_list(result), expected)

    def test_random_cases_iterative(self):
        sol = Solution()
        for _ in range(10):  # Number of random cases to run
            l1, l1_vals = self.generate_random_linked_list()
            l2, l2_vals = self.generate_random_linked_list()
            expected = self.add_lists_as_ints(l1_vals, l2_vals)
            result = sol.addTwoNumbers(l1, l2)
            self.assertEqual(self.linked_to_list(result), expected)

    def test_recursive(self):
        sol = Solution()
        test_cases = [
            ([2, 4, 3], [5, 6, 4], [7, 0, 8]),
            ([0], [0], [0]),
            ([9, 9, 9, 9, 9, 9, 9], [9, 9, 9, 9], [8, 9, 9, 9, 0, 0, 0, 1]),
            ([2, 4, 9], [5, 6, 4, 9], [7, 0, 4, 0, 1]),
        ]
        for l1_vals, l2_vals, expected in test_cases:
            l1 = self.list_to_linked(l1_vals)
            l2 = self.list_to_linked(l2_vals)
            result = sol.addTwoNumbersRecursive(l1, l2)
            self.assertEqual(self.linked_to_list(result), expected)

    def test_random_cases_recursive(self):
        sol = Solution()
        for _ in range(10):
            l1, l1_vals = self.generate_random_linked_list()
            l2, l2_vals = self.generate_random_linked_list()
            expected = self.add_lists_as_ints(l1_vals, l2_vals)
            result = sol.addTwoNumbersRecursive(l1, l2)
            result2 = sol.addTwoNumbers(l1, l2)
            self.assertEqual(self.linked_to_list(result), self.linked_to_list(result2))
            self.assertEqual(self.linked_to_list(result), expected)

if __name__ == "__main__":
    unittest.main()