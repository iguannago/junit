package com.getInTheCloud.junit;

/**
 * Created by davicres on 17/11/2016.
 */
public final class FootballTeam implements Comparable<FootballTeam> {
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

    public int compareTo(FootballTeam o) {
        if (gamesWon < o.gamesWon) {
            return -1;
        } else if (o.getGamesWon() == gamesWon) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "gamesWon=" + gamesWon +
                '}';
    }
}
