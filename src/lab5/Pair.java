package lab5;

public class Pair {
    private String candidate1;
    private String candidate2;
    private int votes1 = 0;
    private int votes2 = 0;

    public String getCandidate1() {
        return candidate1;
    }

    public void setCandidate1(String candidate1) {
        this.candidate1 = candidate1;
    }

    public String getCandidate2() {
        return candidate2;
    }

    public void setCandidate2(String candidate2) {
        this.candidate2 = candidate2;
    }

    public int getVotes1() {
        return votes1;
    }

    public void setVotes1(int votes1) {
        this.votes1 = votes1;
    }

    public int getVotes2() {
        return votes2;
    }

    public void setVotes2(int votes2) {
        this.votes2 = votes2;
    }
}
