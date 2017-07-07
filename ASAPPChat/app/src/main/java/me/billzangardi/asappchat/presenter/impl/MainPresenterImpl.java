package me.billzangardi.asappchat.presenter.impl;

import me.billzangardi.asappchat.model.MainInteractor;
import me.billzangardi.asappchat.model.impl.MainInteractorImpl;
import me.billzangardi.asappchat.presenter.MainPresenter;
import me.billzangardi.asappchat.view.MainView;

/**
 * Created by zangardiw on 7/7/17.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView mView;
    private MainInteractor mInteractor;

    public MainPresenterImpl(MainView view) {
        mView = view;
        mInteractor = new MainInteractorImpl(this);
    }

    @Override
    public void onSendClick(String text) {
        if(text != null && text.trim().length() > 0) {
            mInteractor.sendMessage(text);
        } else {
            mView.showInvalidMessage();
        }
    }
}
