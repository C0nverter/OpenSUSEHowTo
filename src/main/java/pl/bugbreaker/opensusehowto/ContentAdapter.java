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
    private Utils u = new Utils();
    private ArrayList<DataItem> dataSet = u.getDataSet();


    public ContentAdapter(Context mContext, int itemLoaded) {
        this.mContext = mContext;
        this.u.itemLoaded = itemLoaded;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (u.itemLoaded) {
            case 1:
                break;
            case 2:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/yast/");
                notifyDataSetChanged();
                break;
            case 3:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/network/");
                notifyDataSetChanged();
                break;
            case 4:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/users/");
                notifyDataSetChanged();
                break;
            case 5:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/remote/");
                notifyDataSetChanged();
                break;
            case 6:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/disks/");
                notifyDataSetChanged();
                break;
            case 7:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/install/");
                notifyDataSetChanged();
                break;
            case 8:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/custom/");
                notifyDataSetChanged();
                break;
            case 9:
                u.setSectionData("http://susehowto.000webhostapp.com/gui/gvim/");
                notifyDataSetChanged();
                break;
            case 10:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/fs/");
                notifyDataSetChanged();
                break;
            case 11:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/intro/");
                notifyDataSetChanged();
                break;
            case 12:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/vim/");
                notifyDataSetChanged();
                break;
            case 13:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/remote/");
                notifyDataSetChanged();
                break;
            case 14:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/init/");
                notifyDataSetChanged();
                break;
            case 15:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/process/");
                notifyDataSetChanged();
                break;
            case 16:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/users/");
                notifyDataSetChanged();
                break;
            case 17:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/software/");
                notifyDataSetChanged();
                break;
            case 18:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/admin/");
                notifyDataSetChanged();
                break;
            case 19:
                u.setSectionData("http://susehowto.000webhostapp.com/cli/rescue/");
                notifyDataSetChanged();
                break;
        }
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.data_item,parent,false);
        ContentViewHolder viewHolder = new ContentViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.topicTitle.setText(dataSet.get(position).getTopicTitle());
        holder.topicDesc.setText(dataSet.get(position).getTopicDesc());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextView topicTitle;
        private TextView topicDesc;

        public ContentViewHolder(View itemView) {
            super(itemView);

            topicTitle = itemView.findViewById(R.id.topic_title);
            topicDesc = itemView.findViewById(R.id.topic_desc);
        }
    }
}
