package org.separatepid;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) {
        try {
            // Start the server process
            Process server = new ProcessBuilder("java", "-cp", "target/classes", "org.separatepid.Server")
                    .inheritIO()
                    .start();

            // Start the client process
            Process client = new ProcessBuilder("java", "-cp", "target/classes", "org.separatepid.Client")
                    .inheritIO()
                    .start();

            // Wait for both processes to complete
            server.waitFor();
            client.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
