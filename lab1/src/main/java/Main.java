import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static final Utils utils = new Utils();

    public static void main(String[] args) throws Exception {

        char[] pattern = args[1].toCharArray();
        char[] text = Files.readString(Path.of(args[2])).toCharArray();

        switch (args[0]) {
            case "FA" -> {
                FiniteAutomationMatcher finiteAutomationMatcher = new FiniteAutomationMatcher();
                finiteAutomationMatcher.FA(text, pattern, false);
            }
            case "KMP" -> {
                KMPMatcher kmpMatcher = new KMPMatcher();
                kmpMatcher.KMP(pattern, text);
            }
            default -> throw new UnsupportedMatcherTypeException("Matcher type " + args[0] + " doesn't exist!");
        }
    }
}
