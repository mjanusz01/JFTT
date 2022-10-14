import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JavaTests {

    @Test
    public void ASCIIValueReturnsCorrectValuesTest(){
        System.out.println((int)('ł'));
        assertTrue(true);
    }

    @Test
    public void isSuffixTest(){
        // before
        Utils utils = new Utils();
        char[] aba = {'a','b','a'};
        char[] ababa = {'a','b','a','b','a'};
        char[] kaba = {'k','a','b','a'};
        char[] kaka = {'k','a','k','a'};
        char[] kakaka = {'k','a','k','a','k','a'};
        char[] cbaba = {'c','b','a','b','a'};
        // when then
        assertTrue(utils.isSuffix(aba,ababa));
        assertFalse(utils.isSuffix(kaba,ababa));
        assertFalse(utils.isSuffix(kakaka,kaka));
        assertTrue(utils.isSuffix(ababa,ababa));
        assertFalse(utils.isSuffix(cbaba,ababa));
    }
}
