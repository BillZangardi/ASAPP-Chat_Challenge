package me.billzangardi.asappchat.model.impl;

import me.billzangardi.asappchat.model.MainInteractor;
import me.billzangardi.asappchat.presenter.MainPresenter;

/**
 * Created by zangardiw on 7/7/17.
 */

public class MainInteractorImpl implements MainInteractor {
    private MainPresenter mPresenter;

    public MainInteractorImpl(MainPresenter mainPresenter) {
        mPresenter = mainPresenter;
    }
}
