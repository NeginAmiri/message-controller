package org.sameprocess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void testRunGame() {
        // Create players
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        // Link players
        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        // Create threads
        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        // Start threads
        thread1.start();
        thread2.start();

        // Send initial message from player1
        player1.sendMessages("Hi");

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        // Verify that player1 sent at least 10 messages
        assertTrue(player1.getSentMessagesCount() >= 10, "Player 1 should send at least 10 messages.");

        // Verify that player2 received at least 10 messages
        assertTrue(player2.getReceivedMessagesCount() >= 10, "Player 2 should receive at least 10 messages.");
    }
}
