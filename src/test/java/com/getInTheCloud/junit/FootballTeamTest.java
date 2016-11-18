package com.getInTheCloud.junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by davicres on 17/11/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

    @Test
    @Parameters({"0, 0", "3, 3", "5, 5"})
    public void constructorTest(int gamesWon, int expected) {
        FootballTeam footballTeam = FootballTeam.build(gamesWon);
        assertEquals(expected, footballTeam.getGamesWon());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1", "-10", "-30"})
    public void constructorInvalidArgumentTest(int gamesWon) {
        FootballTeam.build(gamesWon);
    }

    @Test
    public void footballTeamWithMoreGamesWonAreGreaterThanFootballTeamWithLessGamesWonTest() {
        List<FootballTeam> footballTeams = buildFootballTeamList(0, 1);
        assertTrue(footballTeams.get(1).compareTo(footballTeams.get(0)) == 1);
    }

    @Test
    public void footballTeamsWithSameGamesWonAreEqualTest() {
        List<FootballTeam> footballTeams = buildFootballTeamList(2, 2);
        assertTrue(footballTeams.get(0).compareTo(footballTeams.get(1)) == 0);
    }

    @Test
    public void footballTeamsWithLessGamesWonAreLessThanTest() {
        List<FootballTeam> footballTeams = buildFootballTeamList(1, 2);
        assertTrue(footballTeams.get(0).compareTo(footballTeams.get(1)) == -1);
    }

    private List<FootballTeam> buildFootballTeamList(int gamesWonTeamA, int gamesWonTeamB) {
        FootballTeam footballTeamA = FootballTeam.build(gamesWonTeamA);
        FootballTeam footballTeamB = FootballTeam.build(gamesWonTeamB);
        List<FootballTeam> footballTeams = new ArrayList<FootballTeam>(2);
        footballTeams.add(footballTeamA);
        footballTeams.add(footballTeamB);
        return footballTeams;
    }

}
