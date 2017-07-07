package me.billzangardi.asappchat.view.impl.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.billzangardi.asappchat.R;
import me.billzangardi.asappchat.model.pojos.Message;

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
        mMessage.setText(message.getText());
    }
}
