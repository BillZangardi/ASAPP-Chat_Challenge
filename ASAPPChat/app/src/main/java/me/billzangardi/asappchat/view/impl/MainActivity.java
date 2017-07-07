package me.billzangardi.asappchat.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> mMessages = new ArrayList<>();

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

    @Override
    public void showInvalidMessage() {
        Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNewMessage(String message) {
        mMessages.add(message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void addMessage(String text) {
        mMessages.add(text);
    }
}
