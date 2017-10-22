package com.example.user.mcfm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.mcfm.Adapter_Item.ChatActivity_RecyclerView_Item;
import com.example.user.mcfm.R;

import java.util.List;

/**
 * Created by User on 2017-10-15.
 */

public class ChatActivity_RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ChatActivity_RecyclerView_Item> list;
    public static final int VIEW_TYPE_YOU = 0;
    public static final int VIEW_TYPE_ME = 1;

    public ChatActivity_RecyclerView_Adapter(Context context, List<ChatActivity_RecyclerView_Item> list) {
        this.context = context;
        this.list = list;
    }
/*
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.chat_name.setText(list.get(position).getChat_name());
        holder.chat_content.setText(list.get(position).getChat_content());
    }*/

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getItemViewType() == VIEW_TYPE_YOU){
            return VIEW_TYPE_YOU;
        }else {
            return VIEW_TYPE_ME;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType  == VIEW_TYPE_YOU){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);

            return new ViewHolder_you(view);
        }else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_me,parent,false);

            return new ViewHolder_me(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatActivity_RecyclerView_Item item = list.get(position);
        if(holder instanceof ViewHolder_you){
            ((ViewHolder_you) holder).chat_content.setText(list.get(position).getChat_content());
        }else {
            ((ViewHolder_me)holder).chat_content.setText(list.get(position).getChat_content());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder_you extends RecyclerView.ViewHolder{
        public TextView chat_name;
        public TextView chat_content;

        public ViewHolder_you(View itemView) {
            super(itemView);
            //chat_name = (TextView)itemView.findViewById(R.id.chat_item_name);
            chat_content = (TextView)itemView.findViewById(R.id.chat_item_content);
        }
    }
    public class ViewHolder_me extends RecyclerView.ViewHolder{
        public TextView chat_content;

        public ViewHolder_me(View itemView) {
            super(itemView);
            chat_content = (TextView)itemView.findViewById(R.id.chat_me_item_content);
        }
    }
}






















