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

    private final List<FootballTeam> footballTeams = buildFootballTeamList();

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
        System.out.println("before sorting... " + footballTeams);
        Collections.sort(footballTeams);
        System.out.println("after sorting... " + footballTeams);
        assertEquals(1, footballTeams.get(0).getGamesWon());
    }

    private List<FootballTeam> buildFootballTeamList() {
        FootballTeam footballTeam_0 = FootballTeam.build(0);
        FootballTeam footballTeam_1 = FootballTeam.build(1);
        List<FootballTeam> footballTeams = new ArrayList<FootballTeam>(2);
        footballTeams.add(footballTeam_0);
        footballTeams.add(footballTeam_1);
        return footballTeams;
    }

    public void footballTeamsWithSameGamesWonAreEqualTest() {

    }

}
