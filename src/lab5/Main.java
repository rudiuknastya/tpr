package lab5;

public class Main {
    public static void main(String[] args) {
        String [][] votingMatrix = { { "c","b","a" },
                { "d","a","b" },
                { "a","d","c" },
                { "b","c","d" } };
        Methods methods = new Methods();
        methods.bordMethod(votingMatrix);
        methods.copeland(votingMatrix);
        methods.parallel(votingMatrix);
    }
}
