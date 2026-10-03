package p0020_valid_parentheses;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesesTest {

    @Test
    void testCases() {
        ValidParentheses solution = new ValidParentheses();

        Map<String, Boolean> testCases = Map.of(
                "()", true,
                "()[]{}", true,
                "(]", false,
                "([])", true,
                "([)]", false
        );

        for (var entry : testCases.entrySet()) {
            assertEquals(
                    entry.getValue(),
                    solution.isValid(entry.getKey())
            );
        }
    }







}