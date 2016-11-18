package com.getInTheCloud.junit;

/**
 * Created by davicres on 17/11/2016.
 */
public final class FootballTeam {
    private final int gamesWon;

    private FootballTeam(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public static FootballTeam build(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("negative number is not valid");
        }
        return new FootballTeam(gamesWon);
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
