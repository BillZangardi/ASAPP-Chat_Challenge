package me.billzangardi.simplechat.view.impl.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.billzangardi.simplechat.R;
import me.billzangardi.simplechat.model.pojos.Message;

/**
 * Created by zangardiw on 7/7/17.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.message)
    TextView mMessage;

    public MessageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setMessage(Message message) {
        switch (message.getContentType()) {
            case PLAIN_TEXT:
                mMessage.setText(message.getText());
                break;
        }
    }
}
