package pl.bugbreaker.opensusehowto;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class AsyncArticleLoad extends AsyncTask<String, Void, ArrayList<Article>> {

    private ArrayList<Article> articleSet;
    private Utils u = Utils.getInstance();

    public AsyncArticleLoad() {
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Article> doInBackground(String... strings) {
        articleSet = new ArrayList<>();
        try {
            Document subDocument = Jsoup.connect(u.getSubURL(u.getSubItemLoaded())).get();
            Elements subDocParagraphSize = subDocument.select("article");
            int mSubDocSize = subDocParagraphSize.size();

            //INFO: artPar = articleParagraph

            for (int i=0; i < mSubDocSize; i++) {
                Elements articleParagraphTitles = subDocument.select("article").select("p[class=article-title]").eq(i);
                String artParTitle = articleParagraphTitles.text();

                Elements artParHTMLContents = subDocument.select("article").select("p[class=article-content]").eq(i);
                String artParHTMLContent = artParHTMLContents.html();

                articleSet.add(new Article(artParTitle,artParHTMLContent));
                Log.d("ArticleItemCreation","Item no. "+i+" added");
                Log.d("ArticleItemCreation","Link: "+u.getSubURL(i));
                Log.d("ArticleItemCreation","Item title: "+articleSet.get(i).getArtParTitle());
                Log.d("ArticleItemCreation","Item description: "+articleSet.get(i).getArtParContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articleSet;
    }

    @Override
    protected void onPostExecute(ArrayList<Article> articles) {
        articles = this.articleSet;
        u.setArticleSet(articles);
    }
}
