package me.billzangardi.simplechat.view;

import me.billzangardi.simplechat.model.pojos.Message;

/**
 * Created by zangardiw on 7/7/17.
 */

public interface MainView {
    void showInvalidMessage();

    void showNewMessage(Message message);
}
