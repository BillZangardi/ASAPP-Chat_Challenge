package me.billzangardi.asappchat.model.pojos;

/**
 * Created by zangardiw on 7/7/17.
 */

public class Message {
    public enum MessageType {
        SENT,
        RECEIVED
    }

    MessageType messageType = MessageType.SENT;
    String text;

    public Message(MessageType messageType, String text) {
        this.messageType = messageType;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}
