# Same-Process Player Communication

## Description
This implementation runs two players in the **same Java process**. Players communicate directly using in-memory objects, without any external dependencies or inter-process communication.

## Features
- Players exchange messages in the same process.
- Messages include a counter to track communication cycles.
- Program terminates gracefully after 10 messages have been exchanged.

## How to Run
1. Compile the code:
   ```bash
   javac -d out src/main/java/org/sameprocess/*.java

2. Run the Main class:
   ```bash
    java -cp out src.main.java.org.sameprocess.Main

## Note
_Ensure Java 17 or later is installed to run the program._