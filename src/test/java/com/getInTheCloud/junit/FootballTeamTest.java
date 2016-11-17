package com.getInTheCloud.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/11/2016.
 */
public class FootballTeamTest {

    @Test
    public void constructorTest() {
        int gamesWon = 0;
        FootballTeam footballTeam = FootballTeam.build(gamesWon);
        gamesWon = footballTeam.getGamesWon();
        assertEquals(0, gamesWon);
    }

}
