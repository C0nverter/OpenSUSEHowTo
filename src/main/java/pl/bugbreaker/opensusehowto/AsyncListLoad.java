package pl.bugbreaker.opensusehowto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class AsyncListLoad extends AsyncTask<String,Void,ArrayList<DataItem>> {

    private Activity activity;
    private String target_url;
    private ArrayList<DataItem> dataSet;
    private Utils u = Utils.getInstance();
    private ProgressDialog dialog;

    public AsyncListLoad(String url, Activity activity) {
        this.activity = activity;
        dialog = new ProgressDialog(activity);
        this.target_url = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setIndeterminate(false);
        dialog.setMessage("Ładowanie zawartości");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected ArrayList<DataItem> doInBackground(String... strings) {
        dataSet = new ArrayList<>();
        try {
            Document mSectionDocument = Jsoup.connect(target_url).get();
            Elements mElementSectionSize = mSectionDocument.select("div[class=section]");
            int mElementSize = mElementSectionSize.size();
            u.clearSubList();
            for (int i=0; i < mElementSize; i++) {
                Elements mElementSectionTitle = mSectionDocument.select("span[class=section-name]").select("a").eq(i);
                String mSectionTitle = mElementSectionTitle.text();

                Elements sectionLinks = mSectionDocument.select("span[class=section-name]").select("a").eq(i);
                String sectionLink = sectionLinks.attr("href");
                u.addSubURL(sectionLink,i);

                Elements mElementSectionDesc = mSectionDocument.select("span[class=section-desc]").eq(i);
                String mSectionDesc = mElementSectionDesc.text();

                dataSet.add(new DataItem(mSectionTitle,mSectionDesc));
                Log.d("DataItemCreation","Item no. "+i+" added");
                Log.d("DataItemCreation","Link: "+u.getURL());
                Log.d("DataItemCreation","Item title: "+dataSet.get(i).getTopicTitle());
                Log.d("DataItemCreation","Item description: "+dataSet.get(i).getTopicDesc());
            }
            publishProgress();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    @Override
    protected void onPostExecute(ArrayList<DataItem> arrayList) {
        arrayList = this.dataSet;
        u.setDataSet(arrayList);
        Log.d("DataSetup","DataSet acquired and loaded.");
        dialog.dismiss();
    }
}
