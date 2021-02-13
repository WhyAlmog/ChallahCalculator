package main;

public class MainClass {

    public static final String LINE_SEPERATOR = "-----------------------";

    /**
     * prints out the proccess required to weave a challah of n strands.
     * 
     * @param strands the amount of strands the challah is made out of
     * @param side    the side to start the process from (right/left - true/false)
     * @param steps   the amount of steps to print (~25 is recommended)
     */
    public static void processChallah(int strands, boolean side, int steps) {
        if (steps == 0)
            return;

        if (side) {
            String line1 = "";
            for (int i = 1; i < strands - 1; i++) {
                line1 += " " + i + " ";
            }
            line1 += "{" + (strands - 1) + "} " + strands;
            System.out.println(line1);

            String line2 = "{" + (strands - 1) + "}";
            for (int i = 1; i < strands - 1; i++) {
                line2 += " " + i + " ";
            }
            line2 += "[" + strands + "]";
            System.out.println(line2);

            String line3 = " " + (strands - 1) + " ";
            for (int i = 1; i < strands / 2 - 1; i++) {
                line3 += " " + i + " ";
            }
            line3 += "[" + strands + "]";
            for (int i = strands / 2; i < strands - 1; i++) {
                line3 += " " + i + " ";
            }
            System.out.println(line3);
        } else {
            String line1 = " 1 {2}";
            for (int i = 3; i <= strands; i++) {
                line1 += " " + i + " ";
            }
            System.out.println(line1);

            String line2 = "[1]";
            for (int i = 3; i <= strands; i++) {
                line2 += " " + i + " ";
            }
            line2 += "{2}";
            System.out.println(line2);

            String line3 = "";
            for (int i = 2; i < strands / 2 + 1; i++) {
                line3 += " " + i + " ";
            }
            line3 += "[1]";
            for (int i = strands / 2 + 2; i <= strands; i++) {
                line3 += " " + i + " ";
            }
            System.out.println(line3);
        }

        System.out.println(LINE_SEPERATOR);

        /* @formatter:off
        ----------------------
         1  2  3  4  5 {6} 7
        {6} 1  2  3  4  5 [7]
         6  1  2 [7] 3  4  5
        ---------------------
         1 {2} 3  4  5  6  7
        [1] 3  4  5  6  7 {2}
         2  3  4 [1] 5  6  7
        */

        processChallah(strands, !side, steps - 1);
    }
}
