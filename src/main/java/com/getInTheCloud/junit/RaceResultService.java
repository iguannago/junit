package com.getInTheCloud.junit;

/**
 * Created by davicres on 01/05/2017.
 */
public class RaceResultService {

    private Client client;

    public void addSubscribe(Client client) {
        this.client = client;
    }

    public void send(Message message) {
        client.receive(message);
    }
}
