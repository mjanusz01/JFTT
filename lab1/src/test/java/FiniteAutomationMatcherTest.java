import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertTrue;

public class FiniteAutomationMatcherTest {

    FiniteAutomationMatcher finiteAutomationMatcher;

    @BeforeEach
    public void setup() {
        finiteAutomationMatcher = new FiniteAutomationMatcher();
    }

    @Test
    public void computeTransitionFunctionCormenReturnsGoodArrayTest(){
        finiteAutomationMatcher = new FiniteAutomationMatcher();
        Utils utils = new Utils();
        char[] pattern = {'a','b','a','b','a','c','a'};
        int[][] result = finiteAutomationMatcher.computeTransitionFunction(pattern);
        utils.printFunction(result);
    }

    @Test
    public void FATest(){
        finiteAutomationMatcher = new FiniteAutomationMatcher();
        Utils utils = new Utils();
        String text = "kawababaccakkakababakababacakababakababalababacacacaca";
        char[] pattern = {'a','b','a','b','a','c','a'};
        char[] textt = text.toCharArray();
        int[][] result = finiteAutomationMatcher.computeTransitionFunction(pattern);
        finiteAutomationMatcher.FA(textt,result,pattern);
    }

}