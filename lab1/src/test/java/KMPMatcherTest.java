import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
        ArrayList<Integer> patternPositions = kmpMatcher.KMP(pattern,textCharArray);
        System.out.println(patternPositions.toString());
    }

    public void getResultsForPatternAndText(String inputPattern, String inputText, String expectedValues){
        KMPMatcher kmpMatcher = new KMPMatcher();
        char[] text = inputText.toCharArray();
        char[] pattern = inputPattern.toCharArray();
        ArrayList<Integer> returnedValuesForPattern1 = kmpMatcher.KMP(pattern,text);
        assertEquals(expectedValues,returnedValuesForPattern1.toString());
    }

    @Test
    public void fromMgrSlowikTests(){
        String text = "ATNTAATNNNAFOOOTFATFNTAATOAFTTOOTOTATOFNOFTNATOFFTOAONFATFNFTNTFTFFTOONTANFTFNAOAAFFFTFTFTTOOTFONONFATATAAFANTFONTOAANAAONNOAONANOONFOAFOTFAONNTFFFFAFAFTFTAFTTNANNANATANFFNFTNATOFAFAFATONONNOTTTANAANATOFTATNTTOFNTNAFANATTTNFATTTATOONTANAFFTTANNAFTFAFTFOAFAAOFONNATTFOANOOTTNOAOFFTTAOOFOTTTFTAFFNFAONATFTAFNNNTOATONTANTFOFNNOOOFFNTFFTNNTNTAFOTAFOTFFOAOFAANTTNNTOTNTFFTNAOOOOOOOOOOFAFNTONNFNAANONOFOFTTNANNNOOFTNAONTTAFAOFNONOONNTOFNNNNNAAATONNNAFANONNNNANNFFAAFFAFNONOTAOOAAATOONONONNATOFOONTONFFTFAOTFANTTFOTNTTTFOTOAOFAAFNATFATTNNFOTFFOOANTFNTOTATTFAFTAFOFTTAAATTOFAOAOFOAAFOONONNTNANFTFFTNFATFFATFFNFANATFNNFAFOTAOANTOAAONAOFOFFAFNAOOAANOTONTNOTATOFNANFTTANOTAOOOFNTFOOTFOAOOFNOFTNFANFTNNOAFOTNAOTOFONNOOFAOFAFFATNTNTFTNONFTOOOOTNAOAAANTOONAAFOATOAFFONTAAFNFAANAOOFFTTFANOTTNAFOTNTFTFNOTAANONNFAATNONTOFOAAONTOOTFFFFAFAFFOAOTNFONOAATOFNFTATFTFNNAOAOONTFTFTTTNNOOTOAAOOOONNNNAFTFNTFFFTATANTFONOOANAOTFATNFAATAFNFOFTOFNTAAAFAAFFAANNNTANOOFAFTONTFOOTFFTFFFAFNNOFFOOFANOFFTTAOTNFANNTFNTAAFNNOOTOTTNNOTANOANFFTTANAOATOTOTOTOTOTOTOTOTOTOTOTOTOTOTOTONFATOFNFFATTOAAAOOFFFAFATOAFOFTTNNNTFTNATAANFNTAFOTFNAOFTTNONOATNFNOOTATFFTOTNONNTTFOAAFOFNFAOOFAAFFAOTFAONONTAFNNNTAFTOFAFONFTAFAATOAATANOONATTTNTNNNOAAOOTTOTNFFFTOANNONTFFOFTFTANTATONNOAOOATANTNTFNTOOFTNFFFTFFFFNATFATTTOTATAOAFOOTOAANOOAFAFANTAOAFFFNAANTTAAATTNTAAFNTFFFTNTFNOATTNNOFFTFOANAAATTFNNFNTFFNOOTFNNFAAAAOATFONFTOAONFTATNNT";
        getResultsForPatternAndText("O", text, "[12, 13, 14, 25, 30, 31, 33, 37, 40, 46, 50, 52, 68, 69, 79, 91, 92, 95, 97, 111, 114, 120, 123, 125, 129, 130, 133, 136, 140, 177, 185, 187, 190, 201, 209, 230, 231, 252, 257, 259, 266, 269, 270, 274, 276, 282, 283, 285, 297, 309, 312, 319, 323, 324, 325, 340, 344, 348, 350, 360, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 384, 392, 394, 396, 405, 406, 411, 418, 421, 423, 424, 428, 439, 447, 464, 466, 469, 470, 475, 476, 478, 480, 485, 487, 488, 491, 498, 506, 513, 515, 517, 532, 536, 537, 544, 555, 564, 567, 569, 571, 575, 576, 578, 612, 615, 619, 622, 625, 627, 634, 635, 639, 641, 645, 649, 659, 662, 663, 664, 669, 670, 673, 675, 676, 679, 690, 693, 697, 699, 701, 704, 705, 708, 722, 726, 727, 728, 729, 733, 739, 740, 745, 748, 752, 764, 765, 773, 779, 787, 792, 800, 803, 805, 808, 811, 812, 823, 825, 829, 831, 835, 848, 850, 851, 862, 863, 865, 868, 869, 870, 871, 892, 894, 895, 899, 913, 916, 936, 937, 942, 946, 947, 959, 962, 963, 967, 973, 989, 990, 992, 997, 1001, 1011, 1014, 1016, 1018, 1020, 1022, 1024, 1026, 1028, 1030, 1032, 1034, 1036, 1038, 1040, 1042, 1044, 1049, 1057, 1061, 1062, 1070, 1073, 1094, 1099, 1104, 1106, 1112, 1113, 1120, 1123, 1129, 1133, 1138, 1139, 1146, 1150, 1152, 1164, 1168, 1177, 1183, 1184, 1195, 1198, 1199, 1202, 1209, 1213, 1218, 1228, 1231, 1233, 1234, 1245, 1246, 1266, 1271, 1274, 1275, 1277, 1281, 1282, 1291, 1322, 1328, 1333, 1350, 1351, 1361, 1365, 1369, 1371]");
        getResultsForPatternAndText("R",text,"[]");
        getResultsForPatternAndText("RO",text,"[]");
        getResultsForPatternAndText("OO",text,"[12, 13, 30, 68, 91, 129, 230, 269, 282, 323, 324, 369, 370, 371, 372, 373, 374, 375, 376, 377, 405, 423, 469, 475, 487, 536, 575, 634, 662, 663, 669, 675, 704, 726, 727, 728, 739, 764, 811, 850, 862, 868, 869, 870, 894, 936, 946, 962, 989, 1061, 1112, 1138, 1183, 1198, 1233, 1245, 1274, 1281, 1350]");
        getResultsForPatternAndText("OOO",text,"[12, 323, 369, 370, 371, 372, 373, 374, 375, 376, 662, 726, 727, 868, 869]");
        getResultsForPatternAndText("OTO",text,"[31, 513, 639, 697, 863, 990, 1014, 1016, 1018, 1020, 1022, 1024, 1026, 1028, 1030, 1032, 1034, 1036, 1038, 1040, 1042, 1275]");
        getResultsForPatternAndText("NN",text,"[7, 8, 121, 141, 161, 188, 242, 260, 305, 306, 321, 333, 357, 385, 402, 403, 425, 430, 431, 432, 433, 440, 441, 448, 449, 450, 453, 481, 529, 579, 607, 688, 702, 793, 845, 860, 872, 873, 874, 930, 931, 957, 978, 987, 995, 1077, 1078, 1124, 1157, 1158, 1192, 1193, 1211, 1229, 1326, 1342, 1354, 1377]");
        getResultsForPatternAndText("TAT",text,"[34, 101, 203, 227, 545, 646, 839, 885, 1114, 1225, 1267, 1374]");
        getResultsForPatternAndText("ONFA",text,"[52, 97, 1044]");
        getResultsForPatternAndText("OFNTF",text,"[664]");
        getResultsForPatternAndText("NAFO",text,"[9, 776]");
        getResultsForPatternAndText("OFAN",text,"[963]");
    }

}