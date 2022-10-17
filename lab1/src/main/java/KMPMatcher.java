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
}
