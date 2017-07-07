package me.billzangardi.asappchat.view.impl.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import me.billzangardi.asappchat.R;
import me.billzangardi.asappchat.model.pojos.Message;
import me.billzangardi.asappchat.view.impl.adapters.viewholders.MessageViewHolder;

/**
 * Created by zangardiw on 7/7/17.
 */

public class ChatAdapter extends RecyclerView.Adapter {

    private static final int SENT_MESSAGE = 0;
    private static final int RECEIVED_MESSAGE = 1;

    private List<Message> mMessages;
    private Context mContext;

    public ChatAdapter(Context context, List<Message> messages) {
        mContext = context;
        mMessages = messages;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RECEIVED_MESSAGE:
                return new MessageViewHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.received_message_layout, parent, false));
            case SENT_MESSAGE:
            default:
                return new MessageViewHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.sent_message_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MessageViewHolder) holder).setMessage(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMessages.get(position).getMessageType().equals(Message.MessageType.RECEIVED)) {
            return RECEIVED_MESSAGE;
        } else {
            return SENT_MESSAGE;
        }
    }
}
