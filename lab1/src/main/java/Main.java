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
                System.out.println("Wzorzec " + args[1] + " występuje na pozycjach " + finiteAutomationMatcher.FA(text, pattern) + " (obliczono algorytmem FA)");
            }
            case "KMP" -> {
                KMPMatcher kmpMatcher = new KMPMatcher();
                System.out.println("Wzorzec " + args[1] + " występuje na pozycjach " + kmpMatcher.KMP(pattern, text) + " (obliczono algorytmem KMP)");
            }
            default -> throw new UnsupportedMatcherTypeException("Matcher type " + args[0] + " doesn't exist!");
        }
    }
}
