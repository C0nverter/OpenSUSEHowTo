package pl.bugbreaker.opensusehowto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public int itemLoaded = 0;

    public int getItemLoaded() {
        return itemLoaded;
    }

    public void setItemLoaded(int itemLoaded) {
        this.itemLoaded = itemLoaded;
    }

    public void setDataSet(ArrayList<DataItem> dataSet) {
        this.dataSet = dataSet;
    }

    public ArrayList<DataItem> dataSet = new ArrayList<>();

    public void setSectionData(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document mSectionDocument = Jsoup.connect(url).get();
                    Elements mElementSectionSize = mSectionDocument.select("div[class=section]");
                    int mElementSize = mElementSectionSize.size();

                    for (int i=0; i < mElementSize; i++) {
                        Elements mElementSectionTitle = mSectionDocument.select("span[class=section-name]").select("a").eq(i);
                        String mSectionTitle = mElementSectionTitle.text();

                        Elements mElementSectionDesc = mSectionDocument.select("span[class=section-desc]").eq(i);
                        String mSectionDesc = mElementSectionDesc.text();

                        dataSet.add(new DataItem(mSectionTitle,mSectionDesc));
                    }
                    setDataSet(dataSet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public ArrayList<DataItem> getDataSet() {
        return dataSet;
    }
}
