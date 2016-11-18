package com.getInTheCloud.junit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        return gamesWon - o.getGamesWon();
    }


    @Override
    public String toString() {
        return "FootballTeam{" +
                "gamesWon=" + gamesWon +
                '}';
    }

    public static void main(String[] args) {
        FootballTeam Barcelona = FootballTeam.build(4);
        FootballTeam Madrid = FootballTeam.build(3);
        FootballTeam AtlMadrid = FootballTeam.build(5);
        List<FootballTeam> teams = new ArrayList<>(3);
        teams.add(Barcelona);
        teams.add(Madrid);
        teams.add(AtlMadrid);
        Collections.sort(teams, Comparator.<FootballTeam>reverseOrder());
        System.out.println("La liga table showing at the top the team with more games won: " + teams);
    }
}
