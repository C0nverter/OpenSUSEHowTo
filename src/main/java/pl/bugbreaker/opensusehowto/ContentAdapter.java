package pl.bugbreaker.opensusehowto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private ArrayList<DataItem> dataSet;
    Utils u = Utils.getInstance();
    private Context context;

    public ContentAdapter(ArrayList<DataItem> itemSet, Context context) {
        this.context = context;
        this.dataSet = itemSet;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public ContentAdapter.ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item,parent,false);
        final ContentViewHolder vHolder = new ContentViewHolder(v);
        vHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SubItemClick","Item "+vHolder.getAdapterPosition()+" is clicked!");
                u.setSubItemLoaded(vHolder.getAdapterPosition());
                Intent run = new Intent(context,DynamicActivity.class);
                Bundle fragData = new Bundle();
                fragData.clear();
                fragData.putString("link",u.getSubURL(vHolder.getAdapterPosition()));
                fragData.putInt("ClickedID",vHolder.getAdapterPosition());
                run.putExtras(fragData);
                context.startActivity(run);
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        holder.topicTitle.setText(dataSet.get(position).getTopicTitle());
        holder.topicDesc.setText(dataSet.get(position).getTopicDesc());
        Log.d("ViewHolderSetup","ViewHolder is bind");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        public CardView itemLayout;
        public TextView topicTitle;
        public TextView topicDesc;
        public ContentViewHolder(View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.dataitem_container);
            topicTitle = itemView.findViewById(R.id.topic_title);
            topicDesc = itemView.findViewById(R.id.topic_desc);
        }
    }
}
