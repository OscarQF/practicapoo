package es.upm.etsisi.poo;

public class Player {
    private String name;
    private double score;
    private boolean matchmaked;

    public Player(){
        this.name = "";
        this.score = 0.0;
        this.matchmaked = false;
    }

    public Player(String name, double score, boolean matchmaking) {
        this.name = name;
        this.score = score;
        this.matchmaked = matchmaking;
    }

    // METODOS
    // GETTERS Y SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean getMatchmaked() {
        return matchmaked;
    }

    public void setMatchmaking(boolean matchmaking) {
        this.matchmaked = matchmaking;
    }



}
