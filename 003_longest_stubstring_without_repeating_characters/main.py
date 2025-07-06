class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxlen = 0
        substr = []
        for i in range(len(s)):
            x = s[i]
            if x not in substr:
                substr.append(x)
            else:
                maxlen = max(maxlen, len(substr))
                substr = substr[substr.index(x)+1:] + [x]
        return max(maxlen, len(substr))

if __name__ == "__main__": 
    sol = Solution()
    test_cases = [
            ("abcabcbb",    3),
            ("bbbbb",       1),
            ("pwwkew",      3),
            ("",            0),
            ("a",           1),
            ("aab",           2),
            ("dvdf",        3)
        ]
    for s, expected in test_cases:
        result = sol.lengthOfLongestSubstring(s)
        print(f"Input: {s}, Expected: {expected}, Got: {result}")
        assert result == expected, f"Test failed for input {s}: expected {expected}, got {result}"