package pl.bugbreaker.opensusehowto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private ArrayList<Article> articleSet;

    public ArticleAdapter(ArrayList<Article> artSet) {
        this.articleSet = artSet;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paragraph,parent,false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.articleTitle.setText(articleSet.get(position).getArtParTitle());
        holder.articleContent.setText(articleSet.get(position).getArtParContent());
    }

    @Override
    public int getItemCount() {
        return articleSet.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        public TextView articleTitle;
        public TextView articleContent;
        public ArticleViewHolder(View itemView) {
            super(itemView);
            articleTitle = itemView.findViewById(R.id.article_title);
            articleContent = itemView.findViewById(R.id.article_content);
        }
    }

}
