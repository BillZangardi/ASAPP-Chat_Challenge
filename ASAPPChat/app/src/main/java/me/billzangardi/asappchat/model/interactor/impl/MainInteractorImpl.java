package me.billzangardi.asappchat.model.interactor.impl;

import me.billzangardi.asappchat.model.interactor.MainInteractor;

/**
 * Created by zangardiw on 7/7/17.
 */

public class MainInteractorImpl implements MainInteractor {
    private Callback mCallback;

    public MainInteractorImpl(Callback callback) {
        mCallback = callback;
    }

    // TODO: Add actual logic, time being just return original message
    @Override
    public void sendMessage(String text) {
        mCallback.onMessageReceived(text);
    }

    public interface Callback {
        void onMessageReceived(String message);
    }
}
