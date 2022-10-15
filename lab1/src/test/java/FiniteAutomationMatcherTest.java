import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class FiniteAutomationMatcherTest {

    public static FiniteAutomationMatcher finiteAutomationMatcher = new FiniteAutomationMatcher();
    public static final Utils utils = new Utils();

    @Test
    public void computeTransitionFunctionCormenReturnsGoodArrayTest() throws IOException {
        char[] pattern = {'a','b','a','b','a','c','a'};
        int[][] result = finiteAutomationMatcher.computeTransitionFunction(pattern);
        utils.printFunction(result);
    }

    @Test
    public void FATest() throws IOException {
        String text = "kawababaccakkakababakababacakababakababalababacacacaca";
        char[] pattern = {'a','b','a','b','a','c','a'};
        char[] textCharArray = text.toCharArray();
        int[][] result = finiteAutomationMatcher.computeTransitionFunction(pattern);
        finiteAutomationMatcher.FA(textCharArray,result,pattern,true);
    }
}