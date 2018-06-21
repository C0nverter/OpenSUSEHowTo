package pl.bugbreaker.opensusehowto;

import android.support.annotation.NonNull;

public class DataItem {

    private String topicTitle;
    private String topicDesc;

    public DataItem() {
    }

    public DataItem(@NonNull final String topicTitle, @NonNull final String topicDesc) {
        setTopicTitle(topicTitle);
        setTopicDesc(topicDesc);
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }
}
