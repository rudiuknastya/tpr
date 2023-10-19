package lab2;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    static Integer [] allLines;
    private static void uniteLines(Integer [] line1, Integer [] line2, Integer [] line3){
        int s = line1.length * 3;
        allLines = new Integer[s];
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
    public static void byDecline (Integer[] line1, Integer [] line2, Integer [] line3){
        Algorithms algorithms = new Algorithms();
        int complexity = 0;
        System.out.println("З впорядкуванням за спаданням: ");
        System.out.println("Рядок 1:");
        complexity = (int) (line1.length*Math.log(line1.length));
        Arrays.sort(line1, Collections.reverseOrder());
        algorithms.nfa(line1, complexity);
        algorithms.ffa(line1, complexity);
        algorithms.wfa(line1, complexity);
        algorithms.bfa(line1, complexity);
        System.out.println("Рядок 2:");
        Arrays.sort(line2, Collections.reverseOrder());
        algorithms.nfa(line2, complexity);
        algorithms.ffa(line2, complexity);
        algorithms.wfa(line2, complexity);
        algorithms.bfa(line2, complexity);
        System.out.println("Рядок 3:");
        Arrays.sort(line3, Collections.reverseOrder());
        algorithms.nfa(line3, complexity);
        algorithms.ffa(line3, complexity);
        algorithms.wfa(line3, complexity);
        algorithms.bfa(line3, complexity);
        System.out.println("Всі рядки:");
        uniteLines(line1, line2, line3);
        complexity = (int) (allLines.length*Math.log(allLines.length));
        Arrays.sort(allLines, Collections.reverseOrder());
        algorithms.nfa(allLines, complexity);
        algorithms.ffa(allLines, complexity);
        algorithms.wfa(allLines, complexity);
        algorithms.bfa(allLines, complexity);
    }

    public static void byIncrease(Integer[] line1, Integer [] line2, Integer [] line3){
        Algorithms algorithms = new Algorithms();
        int complexity = 0;
        System.out.println("З впорядкуванням за зростанням: ");
        System.out.println("Рядок 1:");
        complexity = (int) (line1.length*Math.log(line1.length));
        Arrays.sort(line1);
        algorithms.nfa(line1, complexity);
        algorithms.ffa(line1, complexity);
        algorithms.wfa(line1, complexity);
        algorithms.bfa(line1, complexity);
        System.out.println("Рядок 2:");
        Arrays.sort(line2);
        algorithms.nfa(line2, complexity);
        algorithms.ffa(line2, complexity);
        algorithms.wfa(line2, complexity);
        algorithms.bfa(line2, complexity);
        System.out.println("Рядок 3:");
        Arrays.sort(line3);
        algorithms.nfa(line3, complexity);
        algorithms.ffa(line3, complexity);
        algorithms.wfa(line3, complexity);
        algorithms.bfa(line3, complexity);
        System.out.println("Всі рядки:");
        uniteLines(line1, line2, line3);
        complexity = (int) (allLines.length*Math.log(allLines.length));
        Arrays.sort(allLines);
        algorithms.nfa(allLines, complexity);
        algorithms.ffa(allLines, complexity);
        algorithms.wfa(allLines, complexity);
        algorithms.bfa(allLines, complexity);
    }
    public static void withoutSort(Integer[] line1, Integer [] line2, Integer [] line3){
        Algorithms algorithms = new Algorithms();
        int complexity = 0;
        System.out.println("Без впорядкування: ");
        System.out.println("Рядок 1:");
        algorithms.nfa(line1, complexity);
        algorithms.ffa(line1, complexity);
        algorithms.wfa(line1, complexity);
        algorithms.bfa(line1, complexity);
        System.out.println("Рядок 2:");
        algorithms.nfa(line2, complexity);
        algorithms.ffa(line2, complexity);
        algorithms.wfa(line2, complexity);
        algorithms.bfa(line2, complexity);
        System.out.println("Рядок 3:");
        algorithms.nfa(line3, complexity);
        algorithms.ffa(line3, complexity);
        algorithms.wfa(line3, complexity);
        algorithms.bfa(line3, complexity);
        System.out.println("Всі рядки:");
        uniteLines(line1, line2, line3);
        algorithms.nfa(allLines, complexity);
        algorithms.ffa(allLines, complexity);
        algorithms.wfa(allLines, complexity);
        algorithms.bfa(allLines, complexity);
    }

    public static void main(String[] args) {
        Integer [] line1 = {52,21,93,90,89,9,31,73,64,35,48,95,77,13,33,98,49,55,55,93};
        Integer [] line2 = {68,56,60,33,23,86,71,58,77,40,45,81,61,90,23,50,51,54,75,64};
        Integer [] line3 = {42,24,59,19,89,44,69,38,51,76,83,19,33,43,4,56,81,75,66,11};
        withoutSort(line1,line2,line3);
        System.out.println();
        byIncrease(line1,line2,line3);
        System.out.println();
        byDecline(line1,line2,line3);
    }
}
