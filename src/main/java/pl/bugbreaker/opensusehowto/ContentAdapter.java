package pl.bugbreaker.opensusehowto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private Context mContext;
    private ArrayList<DataItem> dataSet;

    public ContentAdapter(Context mContext, ArrayList<DataItem> itemSet) {
        this.mContext = mContext;
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
        Log.d("ViewHolderSetup","ViewHolder created within "+mContext.toString());
        return new ContentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        holder.topicTitle.setText(dataSet.get(position).getTopicTitle());
        holder.topicDesc.setText(dataSet.get(position).getTopicDesc());
        Log.d("ViewHolderSetup","VievHolder is bind");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        public TextView topicTitle;
        public TextView topicDesc;
        public ContentViewHolder(View itemView) {
            super(itemView);
            topicTitle = itemView.findViewById(R.id.topic_title);
            topicDesc = itemView.findViewById(R.id.topic_desc);
        }
    }
}
