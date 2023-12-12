package lab1;

import java.util.Date;
import java.util.Objects;

public class Main {
    static int [] allLines;
    private static void uniteLines(int [] line1, int [] line2, int [] line3){
        allLines = new int[line1.length*3];
        int j = 0;
        int k = 0;
        for(int i = 0; i < allLines.length; i++){
            if(i < line1.length) {
                allLines[i] = line1[i];
            }
             else if(i >= line1.length && i < line1.length*2){
                allLines[i] = line2[j];
                j++;
            } else {
                allLines[i] = line3[k];
                k++;
            }
        }
    }
    public static void main(String[] args) {
        String s = null;
        String v = "bv";
        System.out.println(Objects.equals(s,v));
    }
}