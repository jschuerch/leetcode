package p0020_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    Map<Character, Character> parentheses = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (parentheses.containsKey(c)) {
                stack.push(parentheses.get(c));
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}