package lab5;

import java.util.*;

public class Methods {
    int[] votesQuantity = {3, 4, 4};
    private <K, V extends Comparable<V>> TreeMap<K, V>
    sortByValues(final TreeMap<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare = map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        TreeMap<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public void bordMethod(String[][] votingMatrix) {
        int[] points = {3, 2, 1, 0};
        TreeMap<String, Integer> results = new TreeMap<>();
        results.put("a", 0);
        results.put("b", 0);
        results.put("c", 0);
        results.put("d", 0);
        for (int i = 0; i < votingMatrix[0].length; i++) {
            int vote = votesQuantity[i];
            for (int j = 0; j < votingMatrix.length; j++) {
                int score = results.get(votingMatrix[j][i]);
                score += vote * points[j];
                results.put(votingMatrix[j][i], score);
            }
        }
        TreeMap<String, Integer> sortedResults =  sortByValues(results);
        System.out.println("Метод Борда: "+sortedResults.firstKey());
    }

    private Pair calculateVotes(String[][] votingMatrix, String candidate1, String candidate2) {
        int[] points = {3, 2, 1, 0};
        Pair pair = new Pair();
        pair.setCandidate1(candidate1);
        pair.setCandidate2(candidate2);
        for (int j = 0; j < votingMatrix[0].length; j++) {
            int c1 = 0;
            int c2 = 0;
            for (int i = 0; i < votingMatrix.length; i++) {
                if (candidate1.equals(votingMatrix[i][j])) {
                    c1 = points[i];
                } else if (candidate2.equals(votingMatrix[i][j])) {
                    c2 = points[i];
                }
            }
            if (c1 > c2) {
                pair.setVotes1(pair.getVotes1() + votesQuantity[j]);
            } else {
                pair.setVotes2(pair.getVotes2() + votesQuantity[j]);
            }
        }
        return pair;
    }

    public void copeland(String[][] votingMatrix) {
        TreeMap<String, Double> results = new TreeMap<>();
        results.put("a", 0d);
        results.put("b", 0d);
        results.put("c", 0d);
        results.put("d", 0d);
        List<Pair> pairs = new ArrayList<>();
        String[] l = {"a", "b", "c", "d"};
        for (int i = 0; i < l.length - 1; i++) {
            String candidate1 = l[i];
            for (int j = i + 1; j < l.length; j++) {
                String candidate2 = l[j];
                pairs.add(calculateVotes(votingMatrix, candidate1, candidate2));
            }
        }
        for (Pair pair : pairs) {
            if (pair.getVotes1() > pair.getVotes2()) {
                double score = results.get(pair.getCandidate1());
                score += 1;
                results.put(pair.getCandidate1(), score);
            } else if (pair.getVotes1() < pair.getVotes2()) {
                double score = results.get(pair.getCandidate2());
                score += 1;
                results.put(pair.getCandidate2(), score);
            } else {
                double score1 = results.get(pair.getCandidate1());
                score1 += 0.5;
                results.put(pair.getCandidate1(), score1);
                double score2 = results.get(pair.getCandidate2());
                score2 += 0.5;
                results.put(pair.getCandidate2(), score2);
            }
        }
        TreeMap<String, Double> sortedResults =  sortByValues(results);
        System.out.println("Метод Копленда: "+sortedResults.firstKey());
    }

    public void parallel(String[][] votingMatrix) {
        TreeMap<String, Double> results = new TreeMap<>();
        results.put("a", 0d);
        results.put("b", 0d);
        results.put("c", 0d);
        results.put("d", 0d);
        List<Pair> pairs = new ArrayList<>();
        String[] l = {"a", "b", "c", "d"};
        for (int i = 0; i < l.length - 1; i += 2) {
            String candidate1 = l[i];
            String candidate2 = l[i + 1];
            pairs.add(calculateVotes(votingMatrix, candidate1, candidate2));
        }
        int i = 0;
        while (pairs.size() >= 2) {
            Pair pair = new Pair();
            if (pairs.get(i).getVotes1() >= pairs.get(i).getVotes2()) {
                pair.setCandidate1(pairs.get(i).getCandidate1());
                pair.setVotes1(pairs.get(i).getVotes1());
            } else  {
                pair.setCandidate1(pairs.get(i).getCandidate2());
                pair.setVotes1(pairs.get(i).getVotes2());
            }
            if (pairs.get(i + 1).getVotes1() >= pairs.get(i + 1).getVotes2()) {
                pair.setCandidate2(pairs.get(i + 1).getCandidate1());
                pair.setVotes2(pairs.get(i + 1).getVotes1());
            } else {
                pair.setCandidate2(pairs.get(i + 1).getCandidate2());
                pair.setVotes2(pairs.get(i + 1).getVotes2());
            }
            pairs.remove(i);
            pairs.remove(i);
            pairs.add(pair);

        }
        if(pairs.get(0).getVotes1() >= pairs.get(0).getVotes2()){
            System.out.println("Метод паралельного виключення: "+pairs.get(0).getCandidate1());
        } else {
            System.out.println("Метод паралельного виключення: "+pairs.get(0).getCandidate2());
        }
    }
}
