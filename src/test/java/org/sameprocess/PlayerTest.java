package org.sameprocess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testSendAndReceiveMessages() {
        // Create players
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        // Link players
        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        // Send a message from player1
        player1.sendMessages("Hello");

        // Verify message counts
        assertEquals(10, player1.getSentMessagesCount(), "Player 1 should send 10 messages.");
        assertEquals(10, player2.getReceivedMessagesCount(), "Player 2 should receive 10 messages.");

        // Verify no extra messages were sent or received
        assertEquals(0, player2.getSentMessagesCount(), "Player 2 should not send any messages in this test.");
        assertEquals(0, player1.getReceivedMessagesCount(), "Player 1 should not receive any messages in this test.");
    }
}
