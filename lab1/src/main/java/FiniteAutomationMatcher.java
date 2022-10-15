public class FiniteAutomationMatcher {

    public static final Utils utils = new Utils();

    FiniteAutomationMatcher() {

    }

    public int[][] computeTransitionFunction(char[] pattern) {
        int m = pattern.length;
        int[][] transitionFunctionValues = new int[pattern.length + 1][256];
        for (int q = 0; q <= m; q++) {
            for (int a = 0; a < 256; a++) {
                System.out.println("g = " + q + ", a = " + a + ", m = " + m);
                int k = Math.min(m + 1, q + 2);
                do {
                    k--;
                } while (!utils.isSuffixWithParameters(pattern, pattern, k, q, a) && k > 0);
                transitionFunctionValues[q][a] = k;
            }
        }
        return transitionFunctionValues;
    }

    public void FA(char[] text, int[][] function, char[] pattern){
        int m = pattern.length;
        int n = text.length;
        int q = 0;
        for(int i = 0; i<n; i++){
            q = function[q][text[i]];
            if(q == m){
                System.out.println("Wzorzec wystąpił w miejscu " + i);
            }
        }
    }
}
