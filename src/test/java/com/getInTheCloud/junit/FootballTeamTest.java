package com.getInTheCloud.junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

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

}
