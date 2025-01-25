package org.sameprocess;

public class message {
    private final String content;
    private final String sender;

    public message(String content, String sender) {

        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }
    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "From" + sender + ": " + content;
    }
}
