package me.billzangardi.simplechat.view.impl;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.billzangardi.simplechat.R;
import me.billzangardi.simplechat.Utils.UiUtils;
import me.billzangardi.simplechat.model.pojos.Message;
import me.billzangardi.simplechat.presenter.MainPresenter;
import me.billzangardi.simplechat.presenter.impl.MainPresenterImpl;
import me.billzangardi.simplechat.view.MainView;
import me.billzangardi.simplechat.view.impl.adapters.ChatAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.message_edit_text)
    EditText mEditText;
    @BindView(R.id.chat)
    RecyclerView mChatList;

    private MainPresenter mPresenter;
    private List<Message> mMessages = new ArrayList<>();
    private ChatAdapter mChatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainPresenterImpl(this);
        mChatAdapter = new ChatAdapter(this, mMessages);
        mChatList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mChatList.setAdapter(mChatAdapter);

        //hide keyboard on scroll to older messages
        mChatList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy < 0) {
                    UiUtils.hideKeyboard(MainActivity.this);
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.center_title_layout);
        actionBar.setTitle(getString(R.string.chat_with_us));

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
    public void showNewMessage(Message message) {
        if (message.getMessageType().equals(Message.MessageType.SENT)) {
            mEditText.setText("");
        }
        mMessages.add(message);
        mChatAdapter.notifyDataSetChanged();
        mChatList.scrollToPosition(mMessages.size() - 1);
    }
}
