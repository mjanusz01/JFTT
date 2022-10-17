import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class KMPMatcherTest {

    @Test
    public void computePrefixFunctionTest(){
        char[] pattern1 = "abaakcabak".toCharArray();
        int[] expectedValuesForPattern1 = {-1, 0, 0, 1, 1, 0, 0, 1, 2, 3, 0};
        KMPMatcher kmpMatcher = new KMPMatcher();
        int[] computedFunctionValuesForPattern1 = kmpMatcher.computePrefixFunction(pattern1);
        Assertions.assertArrayEquals(expectedValuesForPattern1, computedFunctionValuesForPattern1);
    }

}