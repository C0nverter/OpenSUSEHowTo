package pl.bugbreaker.opensusehowto;

import android.support.annotation.NonNull;

public class Article {

    private String artParTitle;
    private String artParContent;

    public Article() {
    }

    public Article(@NonNull final String artTitle, @NonNull final String artContent) {
        setArtParTitle(artTitle);
        setArtParContent(artContent);
    }

    public String getArtParTitle() {
        return artParTitle;
    }

    public void setArtParTitle(String artParTitle) {
        this.artParTitle = artParTitle;
    }

    public String getArtParContent() {
        return artParContent;
    }

    public void setArtParContent(String artParContent) {
        this.artParContent = artParContent;
    }
}
