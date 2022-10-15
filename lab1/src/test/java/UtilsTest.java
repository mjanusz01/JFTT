import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    //maszynka do zwracania wartości ASCII

    @Test
    public void ASCIIValueReturnsCorrectValuesTest(){
        System.out.println((int)('u'));
        assertTrue(true);
    }

    //testy zwykłej metody isSuffix

    @Test
    public void isSuffixTest(){
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

    //test działania metody sprawdzającej czy podany wzorzec dla parametrów k i q oraz a jest sufiksem

    @Test
    public void isSuffixWithParametersTest(){
        Utils utils = new Utils();
        char[] bkcaaaa = {'b','k','c','a','a','a','a'};
        char[] bkcadaa = {'b','k','c','a','d','a','a'};
        char[] bkcada = {'b','k','c','a','d','a'};
        char[] adabkc = {'a','d','a','b','k','c'};
        char[] kpadup = {'k','p','a','d','u','p'};
        char[] bkca = {'b','k','c','a'};
        char[] bkcaefgh = {'b','k','c','a','e','f','g','h'};
        char[] kcdud = {'k','c','d','u','d'};
        char[] dud = {'d','u','d'};
        char[] aba = {'a','b','a'};
        char[] ababa = {'a','b','a','b','a'};
        char[] abakdcpk = {'a','b','a','k','d','c','p','k'};
        char[] abak = {'a','b','a','k'};

        assertTrue(utils.isSuffixWithParameters(bkcadaa,bkca,5,4,100));
        assertTrue(utils.isSuffixWithParameters(bkcadaa,bkcaefgh,5,4,100));
        assertFalse(utils.isSuffixWithParameters(bkcadaa,bkcaefgh,5,5,100));
        assertFalse(utils.isSuffixWithParameters(bkcadaa,bkca,5,4,97));
        assertFalse(utils.isSuffixWithParameters(bkcadaa,bkca,6,4,97));
        assertFalse(utils.isSuffixWithParameters(bkcadaa,bkca,4,4,97));
        assertTrue(utils.isSuffixWithParameters(dud,kcdud,2,5,117));
        assertTrue(utils.isSuffixWithParameters(dud,kcdud,2,5,117));
        assertTrue(utils.isSuffixWithParameters(adabkc,kpadup,3,4,97));
        assertFalse(utils.isSuffixWithParameters(adabkc,kpadup,3,5,97));
        assertFalse(utils.isSuffixWithParameters(adabkc,kpadup,3,6,97));
    }


    //zgodność charów na pozycjach po konkatenacji

    @Test
    public void textsEqualWithExceptionsTest(){
        Utils utils = new Utils();
        char[] abcdefg = {'a','b','c','d','e','f','g'};
        char[] ghciegg = {'g','h','c','i','e','g','g'};
        assertTrue(utils.charsEqualOnPositionsWithAddedChar(abcdefg,ghciegg,6,5,7,97));
        assertTrue(utils.charsEqualOnPositionsWithAddedChar(abcdefg,ghciegg,2,2,7,97));
        assertFalse(utils.charsEqualOnPositionsWithAddedChar(abcdefg,ghciegg,3,3,7,97));
        assertFalse(utils.charsEqualOnPositionsWithAddedChar(abcdefg,ghciegg,3,3,7,97));
        assertTrue(utils.charsEqualOnPositionsWithAddedChar(abcdefg,ghciegg,0,7,7,97));
        assertFalse(utils.charsEqualOnPositionsWithAddedChar(abcdefg,ghciegg,1,7,7,97));
    }
}
