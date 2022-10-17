import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KMPMatcherTest {

    @Test
    public void computePrefixFunctionTest(){
        char[] pattern1 = "abaakcabak".toCharArray();
        int[] expectedValuesForPattern1 = {-1, 0, 0, 1, 1, 0, 0, 1, 2, 3, 0};
        char[] pattern2 = "ababaca".toCharArray();
        int[] expectedValuesForPattern2 = {-1, 0, 0, 1, 2, 3, 0, 1};
        char[] pattern3 = "ooooo".toCharArray();
        int[] expectedValuesForPattern3 = {-1, 0, 1, 2, 3, 4};
        char[] pattern4 = "testtesttesttesttesttest".toCharArray();
        int[] expectedValuesForPattern4 = {-1, 0, 0, 0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        KMPMatcher kmpMatcher = new KMPMatcher();
        int[] computedFunctionValuesForPattern1 = kmpMatcher.computePrefixFunction(pattern1);
        int[] computedFunctionValuesForPattern2 = kmpMatcher.computePrefixFunction(pattern2);
        int[] computedFunctionValuesForPattern3 = kmpMatcher.computePrefixFunction(pattern3);
        int[] computedFunctionValuesForPattern4 = kmpMatcher.computePrefixFunction(pattern4);
        Assertions.assertArrayEquals(expectedValuesForPattern1, computedFunctionValuesForPattern1);
        Assertions.assertArrayEquals(expectedValuesForPattern2, computedFunctionValuesForPattern2);
        Assertions.assertArrayEquals(expectedValuesForPattern3, computedFunctionValuesForPattern3);
        Assertions.assertArrayEquals(expectedValuesForPattern4, computedFunctionValuesForPattern4);
    }

    @Test
    public void KMPTest(){
        KMPMatcher kmpMatcher = new KMPMatcher();
        String text = "kawababacaakkakababakababacakababakababalababacacacaca";
        char[] pattern = {'a','b','a','b','a','c','a'};
        char[] textCharArray = text.toCharArray();
        kmpMatcher.KMP(pattern,textCharArray);
    }

}