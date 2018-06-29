package pl.bugbreaker.opensusehowto;

import android.os.AsyncTask;
import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class AsyncListLoad extends AsyncTask<String,Void,ArrayList<DataItem>> {

    private String target_url;
    private ArrayList<DataItem> dataSet;
    private Utils u = Utils.getInstance();

    public AsyncListLoad(String url) {
        this.target_url = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.d("DataLoad","Data created");
    }

    @Override
    protected ArrayList<DataItem> doInBackground(String... strings) {
        dataSet = new ArrayList<>();
        try {
            Document mSectionDocument = Jsoup.connect(target_url).get();
            Elements mElementSectionSize = mSectionDocument.select("div[class=section]");
            int mElementSize = mElementSectionSize.size();

            for (int i=0; i < mElementSize; i++) {
                Elements mElementSectionTitle = mSectionDocument.select("span[class=section-name]").select("a").eq(i);
                String mSectionTitle = mElementSectionTitle.text();

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
    }
}
