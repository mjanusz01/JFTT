import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FiniteAutomationMatcher {

    public static final Utils utils = new Utils();
    public static final Logger logger = Logger.getLogger(FiniteAutomationMatcher.class.getName());

    public int[][] computeTransitionFunction(char[] pattern) {
        int m = pattern.length;
        int[][] transitionFunctionValues = new int[pattern.length + 1][256];
        for (int q = 0; q <= m; q++) {
            for (int a = 0; a < 256; a++) {
                int k = Math.min(m + 1, q + 2);
                do {
                    k--;
                } while (!utils.isSuffixWithParameters(pattern, pattern, k, q, a) && k > 0);
                transitionFunctionValues[q][a] = k;
            }
        }
        return transitionFunctionValues;
    }

    public ArrayList<Integer> FA(char[] text, char[] pattern){
        ArrayList<Integer> results = new ArrayList<>();
        int[][] function = computeTransitionFunction(pattern);
        int m = pattern.length;
        int n = text.length;
        int q = 0;
        for(int i = 0; i<n; i++){
            q = function[q][text[i]];
            if(q == m){
                results.add(i - pattern.length + 1);
            }
        }
        return results;
    }


}
