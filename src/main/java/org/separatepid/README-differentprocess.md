# Separate-Process Player Communication

## Description
This implementation runs two players in **separate Java processes**. Players communicate via socket-based inter-process communication, simulating a client-server architecture.

## Features
- Players are launched as separate Java processes.
- Server handles message routing and manages communication between players.
- Client initiates communication and interacts with the server.
- Program terminates gracefully after 10 message exchanges.

## How to Run
1. Compile the code:
   ```bash
   javac -d out src/main/java/org/separatepid/*.java
 
2. Open a terminal for server in `src`
   ```bash
   java -cp out main.java.org.separatepid.Server

3. Open a terminal for client in `src`
   ```
   java -cp out main.java.org.separatepid.Client
Alternatively, run the both processes manually.

## Note
_Ensure Java 17 or later is installed._

_Verify that the default socket port (e.g., 8080) is not in use._

## Optimization Plan
 - To use a `shared package` for common classes and usages
 - To implement a hierarchy for players to be able to connect through a channel `interface`
 - To add more `tests`