package org.separatepid;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Starting server...");

        try(Socket socket = new Socket(HOST,PORT)){
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for (int i = 0; i<10; i++){
                String message = "Message " + i;
                System.out.println("Sending: " + message);
                out.println(message);

                String response = in.readLine();
                System.out.println("Received response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping server...");
    }
}
