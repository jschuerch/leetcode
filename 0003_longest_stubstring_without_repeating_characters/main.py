class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxlen = 0
        seen = set()
        start = 0
        for end in range(len(s)):
            while s[end] in seen:
                seen.remove(s[start])
                start += 1
            seen.add(s[end])
            maxlen = max(maxlen, end - start + 1)
        return maxlen

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