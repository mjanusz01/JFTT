import java.util.ArrayList;

public class KMPMatcher {

    public int[] computePrefixFunction(char[] pattern){
        Utils utils = new Utils();
        int[] functionValues = new int[pattern.length+1];
        functionValues[0] = -1;
        functionValues[1] = 0;
        int k = 0;
        for(int q = 2; q<=pattern.length; q++){
            while(k>0 && !utils.compareWithBoundary(pattern,k,q)){
                k = functionValues[k];
            }
            if(utils.compareWithBoundary(pattern,k,q)){
                k++;
            }
            functionValues[q] = k;
        }
        return functionValues;
    }

    public ArrayList<Integer> KMP(char[] pattern, char[] text){
        Utils utils = new Utils();
        ArrayList<Integer> results = new ArrayList<>();
        int m = pattern.length;
        int[] computedFunctionValues = computePrefixFunction(pattern);
        int q = 0;
        for(int i = 0; i<text.length; i++){
            while(utils.comparePatternWithBoundary(q,m,i,pattern,text)){
                q = computedFunctionValues[q];
            }
            if(pattern[q]==text[i]){
                q++;
            }
            if(q == m){
                results.add(i - pattern.length + 1);
                System.out.println("Wzorzec wystąpił w miejscu " + (i - pattern.length + 1));
            }
        }
        return results;

    }
}
