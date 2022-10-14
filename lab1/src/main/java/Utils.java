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
}
