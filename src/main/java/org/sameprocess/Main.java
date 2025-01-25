package org.sameprocess;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");


        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();

        player1.sendMessages("Hi");

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }


        System.out.println("over");
    }
}