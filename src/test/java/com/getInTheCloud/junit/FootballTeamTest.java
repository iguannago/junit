package com.getInTheCloud.junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        System.out.println("before sorting... " + footballTeams);
        assertEquals(0, footballTeams.get(0).getGamesWon());
        Collections.sort(footballTeams);
        System.out.println("after sorting... " + footballTeams);
        assertEquals(1, footballTeams.get(0).getGamesWon());
    }

    private List<FootballTeam> buildFootballTeamList(int gamesWonTeam0, int gamesWonTeam1) {
        FootballTeam footballTeam_0 = FootballTeam.build(gamesWonTeam0);
        FootballTeam footballTeam_1 = FootballTeam.build(gamesWonTeam1);
        List<FootballTeam> footballTeams = new ArrayList<FootballTeam>(2);
        footballTeams.add(footballTeam_0);
        footballTeams.add(footballTeam_1);
        return footballTeams;
    }

    @Test
    public void footballTeamsWithSameGamesWonAreEqualTest() {
    }

}
