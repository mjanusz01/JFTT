import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public byte[] getByteArrayFromFilePath(Path path) throws IOException {
        return Files.readAllBytes(path);
    }

    public boolean isSuffix(char[] suffixSUT, char[] text){
        int tempSuffixCharPosition = suffixSUT.length - 1;
        int tempTextCharPosition = text.length - 1;
        if(tempSuffixCharPosition>tempTextCharPosition){
            return false;
        }
        while(tempSuffixCharPosition>=0){
            if(suffixSUT[tempSuffixCharPosition] == text[tempTextCharPosition]){
                tempSuffixCharPosition--;
                tempTextCharPosition--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean isSuffixWithParameters(char[] suffixSUT, char[] text, int k, int q, int a){
        if(k>q+1 || k>suffixSUT.length || q>text.length){
            return false;
        }
        int textLength = text.length;
        int tempSuffixCharPosition = k - 1;
        int tempTextCharPosition = q;
        while(tempSuffixCharPosition>=0){
            if(charsEqualOnPositionsWithAddedChar(suffixSUT,text,tempSuffixCharPosition,tempTextCharPosition,q,a)){
                tempSuffixCharPosition--;
                tempTextCharPosition--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean charsEqualOnPositionsWithAddedChar(char[] suffixSUT, char[] text, int tempSuffixCharPosition, int tempTextCharPosition, int q, int a){
        if(tempTextCharPosition == q){
            return suffixSUT[tempSuffixCharPosition] == a;
        }
        else{
            return suffixSUT[tempSuffixCharPosition] == text[tempTextCharPosition];
        }
    }

    public void printFunction(int[][] function){
        for(int i = 0; i<function.length; i++){
            for(int j = 0; j<function[0].length; j++){
                System.out.print(function[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public boolean compareWithBoundary(char[] pattern, int k, int q){
        if(k<=pattern.length){
            return pattern[k]==pattern[q-1];
        }
        else {
            return false;
        }
    }

    public boolean comparePatternWithBoundary(int q, int m, int i, char[] pattern, char[] text){
        boolean compareValue = true;
        if(q<m){
            compareValue = pattern[q]!=text[i];
        }
        return q>0 && compareValue;
    }

    public boolean comparePatternWithBoundary2(int q, int m, int i, char[] pattern, char[] text){
        if(q<m){
            return pattern[q]==text[i];
        }
        else{
            return false;
        }
    }
}
