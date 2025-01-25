package org.separatepid;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8080;
    public static void main(String[] args) {
        System.out.println("Starting server...");
        int messageCounter = 0;

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket clientSocket = serverSocket.accept(); //wait and accept
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


            String receivedMessage;
            while ((receivedMessage = in.readLine()) != null) {
                System.out.println("Received: " + receivedMessage);

                // response back
                String response = receivedMessage + "| Counter:" + messageCounter++;
                out.println(response);

                if (messageCounter >= 10) { // stop condition
                    System.out.println("Message limit reached.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping server...");
    }

}
