class Solution:
    def reverse(self, x: int) -> int:
        sign = [-1, 1][x >= 0]
        reverse, x = 0, abs(x)
        INTMAX = (2**31) - 1

        while x > 0:
            digit = x % 10
            x = x // 10

            if reverse > INTMAX/10:
                return 0
            reverse = reverse * 10 + digit

        return sign * reverse


if __name__ == "__main__":
    sol = Solution()
    test_cases = [
            (123, 321),
            (-123, -321),
            (120, 21),
            (0, 0)
    ]

    for x, expected in test_cases:
        print(f"Input: \t\t{x}")
        result = sol.reverse(x)
        print(f"Expected: \t{expected} \nGot: \t\t{result}")
        print()
        assert result == expected