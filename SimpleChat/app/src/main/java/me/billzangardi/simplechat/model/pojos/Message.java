package me.billzangardi.simplechat.model.pojos;

/**
 * Created by zangardiw on 7/7/17.
 */

public class Message {

    public enum MessageType {
        SENT,
        RECEIVED
    }

    public enum ContentType {
        PLAIN_TEXT,
        MULTIMEDIA,
        BILL
    }

    private MessageType messageType = MessageType.SENT;
    private String text;
    private ContentType contentType = ContentType.PLAIN_TEXT;

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

    public ContentType getContentType() {
        return contentType;
    }
}
