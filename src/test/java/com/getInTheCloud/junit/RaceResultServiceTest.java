package com.getInTheCloud.junit;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by davicres on 01/05/2017.
 */
public class RaceResultServiceTest {
    @Test
    public void subscribedClientShouldReceivedMessage() throws Exception {
        RaceResultService raceResultService = new RaceResultService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);
        raceResultService.addSubscribe(client);
        raceResultService.send(message);
        verify(client).receive(message);
    }
}
