package org.sameprocess;

public class Player implements Runnable {
    private String name;
    private Player otherPlayer;
    private int sentMessagesCount = 0;
    private int receivedMessagesCount = 0;

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Set the other player
    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    // send a message
    public void sendMessages(String message) {
        // Simulate sending and receiving messages
        while (sentMessagesCount < 10) {
            sentMessagesCount++;
            System.out.println(this.name + " sent: " + message);
            otherPlayer.receiveMessage(message + " " + sentMessagesCount);
        }
    }

    // receive a message
    public void receiveMessage(String message) {
        receivedMessagesCount++;
        System.out.println(this.name + " received: " + message);
    }

    // Getter for sentMessagesCount
    public int getSentMessagesCount() {
        return sentMessagesCount;
    }

    // Getter for receivedMessagesCount
    public int getReceivedMessagesCount() {
        return receivedMessagesCount;
    }

    @Override
    public void run() {
        // separate thread
        sendMessages("Hi");
    }
}
