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
    public void footballTeamWith1GamesWonIsGreaterThanFootbalTeamWith0GamesWonTest() {
        FootballTeam footballTeamWithZeroGamesWon = FootballTeam.build(0);
        FootballTeam footballTeamWithOneGamesWon = FootballTeam.build(1);
        List<FootballTeam> footballTeams = new ArrayList<FootballTeam>(2);
        footballTeams.add(footballTeamWithZeroGamesWon);
        footballTeams.add(footballTeamWithOneGamesWon);
        System.out.println("before sorting... " + footballTeams);
        Collections.sort(footballTeams);
        System.out.println("after sorting... " + footballTeams);
        assertEquals(1, footballTeams.get(0).getGamesWon());
    }

}
