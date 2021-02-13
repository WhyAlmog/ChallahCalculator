package main;

import java.util.Scanner;

public class MainClass {

    public static final String LINE_SEPERATOR = "---";
    public static final String STRAND_COUNT_QUERY = "Enter strand count:";
    public static final String SIDE_QUERY = "Enter which side to start from:";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(STRAND_COUNT_QUERY);
        int strands = scanner.nextInt();
        System.out.println(SIDE_QUERY);
        String side = scanner.nextLine();

        processChallah(strands, side);
        scanner.close();
    }

    /**
     * prints out the proccess required to weave a challah of n strands.
     * 
     * @param strands the amount of strands the challah is made out of
     * @param side    the side to start the process from (right/left - true/false)
     * @param steps   the amount of steps to print (~25 is recommended)
     */
    public static void processChallah(int strands, String side) {
        System.out.println(
                side.equalsIgnoreCase("right") || side.equalsIgnoreCase("r") ? rightSide(strands) + leftSide(strands)
                        : leftSide(strands) + rightSide(strands));
    }

    /**
     * @param strands strand count
     * @return process string
     * 
     * @formatter:off
     *  1 {2} 3  4  5  6  7
     *  [1] 3  4  5  6  7 {2}
     *  2  3  4 [1] 5  6  7
     * @formatter:on
     */
    public static String rightSide(int strands) {
        String out = "";

        String line1 = " 1 {2}";
        for (int i = 3; i <= strands; i++) {
            line1 += " " + i + " ";
        }
        out += line1 + "\n";

        String line2 = "[1]";
        for (int i = 3; i <= strands; i++) {
            line2 += " " + i + " ";
        }
        line2 += "{2}";
        out += line2 + "\n";

        String line3 = "";
        for (int i = 2; i < strands / 2 + 2; i++) {
            line3 += " " + i + " ";
        }
        line3 += "[1]";
        for (int i = strands / 2 + 2; i <= strands; i++) {
            line3 += " " + i + " ";
        }
        out += line3 + " \n";

        for (int i = 0; i < strands; i++) {
            out += LINE_SEPERATOR;
        }
        out += "\n";
        return out;
    }

    /** 
     * @param strands strand count
     * @return process string
     * 
     * @formatter:off
     *   1  2  3  4  5 {6} 7
     *  {6} 1  2  3  4  5 [7]
     *   6  1  2 [7] 3  4  5
     *  ---------------------
     * @formatter:on
     */
    public static String leftSide(int strands) {
        String out = "";

        String line1 = "";
        for (int i = 1; i < strands - 1; i++) {
            line1 += " " + i + " ";
        }
        line1 += "{" + (strands - 1) + "} " + strands;
        out += line1 + "\n";

        String line2 = "{" + (strands - 1) + "}";
        for (int i = 1; i < strands - 1; i++) {
            line2 += " " + i + " ";
        }
        line2 += "[" + strands + "]";
        out += line2 + "\n";

        String line3 = " " + (strands - 1) + " ";
        for (int i = 1; i < strands / 2; i++) {
            line3 += " " + i + " ";
        }
        line3 += "[" + strands + "]";
        for (int i = strands / 2; i < strands - 1; i++) {
            line3 += " " + i + " ";
        }
        out += line3 + " \n";
        for (int i = 0; i < strands; i++) {
            out += LINE_SEPERATOR;
        }
        out += "\n";
        return out;
    }
}
