package pl.bugbreaker.opensusehowto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Utils {

    private static final Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    public ArrayList<String> subURL = new ArrayList<>();

    public String getSubURL(int i) {
        return subURL.get(i);
    }

    public void addSubURL(String subURL, int stringIndex) {
        this.subURL.add(stringIndex,subURL);
    }

    public void clearSubList() {
        subURL.clear();
    }

    public int itemLoaded = 0;
    public int subItemLoaded;
    private ArrayList<DataItem> dataSet = new ArrayList<>();
    private ArrayList<Article> articleSet = new ArrayList<>();

    public int getItemLoaded() {
        return itemLoaded;
    }

    public void setItemLoaded(int itemLoaded) {
        this.itemLoaded = itemLoaded;
    }

    public void setDataSet(ArrayList<DataItem> dataSet) {
        this.dataSet = dataSet;
    }

    public ArrayList<DataItem> getDataSet() {
        return dataSet;
    }

    public ArrayList<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(ArrayList<Article> articleSet) {
        this.articleSet = articleSet;
    }

    public int getSubItemLoaded() {
        return subItemLoaded;
    }

    public void setSubItemLoaded(int subItemLoaded) {
        this.subItemLoaded = subItemLoaded;
    }

    public String getURL() {
        switch (this.getItemLoaded()) {
            case 1:
                return "http://susehowto.dx.am/gui/yast";
            case 2:
                return "http://susehowto.dx.am/gui/network";
            case 3:
                return "http://susehowto.dx.am/gui/users";
            case 4:
                return "http://susehowto.dx.am/gui/remote";
            case 5:
                return "http://susehowto.dx.am/gui/disks";
            case 6:
                return "http://susehowto.dx.am/gui/install";
            case 7:
                return "http://susehowto.dx.am/gui/custom";
            case 8:
                return "http://susehowto.dx.am/gui/gvim";
            case 9:
                return "http://susehowto.dx.am/cli/fs";
            case 10:
                return "http://susehowto.dx.am/cli/intro";
            case 11:
                return "http://susehowto.dx.am/cli/vim";
            case 12:
                return "http://susehowto.dx.am/cli/remote";
            case 13:
                return "http://susehowto.dx.am/cli/init";
            case 14:
                return "http://susehowto.dx.am/cli/process";
            case 15:
                return "http://susehowto.dx.am/cli/users";
            case 16:
                return "http://susehowto.dx.am/cli/software";
            case 17:
                return "http://susehowto.dx.am/cli/admin";
            case 18:
                return "http://susehowto.dx.am/cli/rescue";
            default:
                return "";
        }
    }
}
