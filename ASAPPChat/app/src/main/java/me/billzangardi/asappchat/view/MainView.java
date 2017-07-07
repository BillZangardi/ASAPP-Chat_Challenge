package me.billzangardi.asappchat.view;

/**
 * Created by zangardiw on 7/7/17.
 */

public interface MainView {
    void showInvalidMessage();

    void showNewMessage(String message);

    void addMessage(String text);
}
