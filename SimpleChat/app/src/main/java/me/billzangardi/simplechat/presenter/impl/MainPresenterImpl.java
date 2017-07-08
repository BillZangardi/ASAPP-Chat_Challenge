package me.billzangardi.simplechat.presenter.impl;

import me.billzangardi.simplechat.model.interactor.MainInteractor;
import me.billzangardi.simplechat.model.interactor.impl.MainInteractorImpl;
import me.billzangardi.simplechat.model.pojos.Message;
import me.billzangardi.simplechat.presenter.MainPresenter;
import me.billzangardi.simplechat.view.MainView;

/**
 * Created by zangardiw on 7/7/17.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractorImpl.Callback {
    private MainView mView;
    private MainInteractor mInteractor;

    public MainPresenterImpl(MainView view) {
        mView = view;
        mInteractor = new MainInteractorImpl(this);
    }

    @Override
    public void onSendClick(String text) {
        if(text != null && text.trim().length() > 0) {
            mView.showNewMessage(new Message(Message.MessageType.SENT, text));
            mInteractor.sendMessage(text);
        } else {
            mView.showInvalidMessage();
        }
    }

    @Override
    public void onMessageReceived(String message) {
        mView.showNewMessage(new Message(Message.MessageType.RECEIVED, message));
    }
}
