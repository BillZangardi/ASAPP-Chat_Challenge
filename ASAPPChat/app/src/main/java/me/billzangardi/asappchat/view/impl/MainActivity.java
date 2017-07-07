package me.billzangardi.asappchat.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.billzangardi.asappchat.R;
import me.billzangardi.asappchat.presenter.MainPresenter;
import me.billzangardi.asappchat.presenter.impl.MainPresenterImpl;
import me.billzangardi.asappchat.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.message_edit_text)
    EditText mEditText;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainPresenterImpl(this);
    }

    @OnClick(R.id.btn_send)
    public void onSendClick() {
        mPresenter.onSendClick(mEditText.getText().toString());
    }
}
